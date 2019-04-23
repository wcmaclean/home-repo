// A servlet that requests input from the user to create
// a TradeBean. 

package examples.trade; 

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.Integer;
import java.lang.reflect.Array;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

import java.lang.Long;
import java.lang.Integer;
import java.lang.String;

public class TradeServlet extends HttpServlet {


	public void init(){}

	public void destroy(){}
		
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
			PrintWriter out = response.getWriter();
	
        out.println("<html>");
        out.println("<head>");
        String title = "Trade";
        out.println("<title>" + title + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + title + "</h1>");
        String param = request.getParameter("param");
        if (param != null) {
            out.println("Thanks for the lovely param='" + param + "' binding.");
        }   

   	out.println("<P>");
   	out.print("<form action=\" ");
		out.print(response.encodeURL("TradeServlet"));

   	out.print("\" ");
   	out.println("method=POST>");
   	out.println("LIMIT:");
		out.println("<input type=\"text\" size=100 name=\"limit\">");
		out.println("<br>");
      out.println("Client ID:");
		out.println("<input type=\"text\" size=100 name=\"aClientID\">");
		out.println("<br>");
		//out.println("Client Sequence ID:");
		//out.println("<input type=\"text\" size=100 name=\"clSeqID\">");
		//out.println("<br>");
      out.println("Quantity:");
		out.println("<input type=\"text\" size=100 name=\"aQuantity\">");
		out.println("<br>");
      out.println("Price:");
		out.println("<input type=\"text\" size=100 name=\"price\">");
		out.println("<br>");
      out.println("<br>");
      out.println("<input type=\"submit\" value=\"Go\" >");
      out.println("<input type=\"reset\" value=\"Clear\" >");
		out.println("<br>");
		out.println("<br>");
      out.println("</form>");
      out.println("</body>");
      out.println("</html>");
    } // close doGet

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
        throws IOException, ServletException
    {
        response.setContentType("text/html");
			PrintWriter out = response.getWriter();   

	// start page stuff
         String title = "Trade";

         out.println("<HTML><HEAD><TITLE>");
         out.println(title);
         out.println("</TITLE></HEAD><BODY>");
         out.println("<H1>" + title + "</H1>");
         String str = request.getParameter("str");
			
    	// get the variables
        String limit = request.getParameter("limit");
        long clientID = Long.parseLong(request.getParameter("aClientID")); 
        //long tempLong = Long.parseLong(request.getParameter("clSeqID"));       
			// get a new SeqCount for ClSeqID 
			
			// Access SeqCount to get the next ClSeqID. 
        	SeqCount aSeqCount = new SeqCount();
        	long tempClSeqID = aSeqCount.getSeqCount();
        	//out.println(aSeqCount.getSeqCount());
        	//out.println(tempClSeqID);
        Long clSeqID = new Long(tempClSeqID);    
        
        // get the rest of the variables
        int quantity = Integer.parseInt(request.getParameter("aQuantity"));    
        int price = Integer.parseInt(request.getParameter("price"));       
        long clTime = System.currentTimeMillis();

        // accessing weblogic and bean stuff
	try {

	    // connect to weblogic and Trade bean
	    Properties props = System.getProperties(); 
	    props.setProperty("java.naming.factory.initial",
				"weblogic.jndi.WLInitialContextFactory");
	    props.setProperty("java.naming.provider.url",
				"t3://localhost:7001");
	    InitialContext ctx = new InitialContext(props);
	    
	    // get ClSeqID 
	    
	    Object obj = ctx.lookup("RemoteTraderHome");	    
	    TradeHome home = (TradeHome)javax.rmi.PortableRemoteObject.narrow(obj, 
			TradeHome.class);
			
	    // create a Trade bean with the data	
	    home.create(limit, clientID, clSeqID, quantity, price, clTime);

		// query the db and spit out
		Iterator i = home.findAllTrades().iterator();
		
		// Acknowledge the order.
		out.println("<h>ACK</h>");
		Trade aTrade = null;
		while (i.hasNext()) {
			aTrade = (Trade) javax.rmi.PortableRemoteObject.narrow(i.next(), Trade.class);
				out.println("<b>LIMIT: </b><p>" + aTrade.getLimit() + "</p>");
				out.println("<b>ClientID: </b><p>" + aTrade.getClientID() + "</p>");
				out.println("<b>ClientSeqID: </b><p>" + aTrade.getClSeqID() + "</p>");
				out.println("<b>Quantity: </b><p>" + aTrade.getQuantity() + "</p>");
				out.println("<b>Price: </b><p>" + aTrade.getPrice() + "</p>");
				out.println("<b>ClTime: </b><p>" + aTrade.getClTime() + "</p>");

		}
		

	    //aTrade.remove();
	} catch (Exception e) {
	    out.println(e);
	}




         out.println("</BODY></HTML>");
         out.close();

    } // close doPost
} // close SQLQuery class