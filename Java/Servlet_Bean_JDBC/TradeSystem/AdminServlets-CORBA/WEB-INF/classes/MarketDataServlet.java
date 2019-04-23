import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import SQLQueryResultSet.*;
import java.lang.Integer;
import java.lang.reflect.Array;

public class MarketDataServlet extends HttpServlet {

	SQLQueryResultSet.ResultSetCORBA aResultSetCORBA = null;
		
    public void doGet(HttpServletRequest request, 
		HttpServletResponse response) throws IOException, ServletException {

      response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	// plan the query
	String aQuery = "SELECT * FROM Volume";
	String aQuery2 = "SELECT * FROM TradeTotal";


    	// setting properties
    	Properties prop = new Properties();
    	prop.put("org.omg.CORBA.ORBClass", "com.inprise.vbroker.orb.ORB");
    	prop.put("org.omg.CORBA.SingletonClass", "com.inprise.vbroker.orb.ORB");
  
    	// Initialize the ORB.
   	org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(new String[0], prop);

    	// Get the manager Id
		byte[] aSQLQueryResultSet_Id = "aSQLQueryResultSet_Manager".getBytes();

    	// Locate an SQL Querier. Give the full POA name and the servant ID.
		//SQLQueryResultSet.ResultSetSeq aSQLQueryResultSet = 
		aResultSetCORBA = 
			SQLQueryResultSet.ResultSetCORBAHelper.bind
				(orb, "/SQLQueryResultSet_agent_poa", aSQLQueryResultSet_Id);

		// set up database stuff
		Statement aStatement = null;
		ResultSet aResultSet = null;

		// start the page
        out.println("<html>");
        out.println("<head>");
        String title = "Market Data Client";
        out.println("<title>" + title + "</title>");
        out.println("</head>");
		  //out.println("<META HTTP-EQUIV=\"REFRESH\"	Content=\"10;URL=http://guts.cs.uchicago.edu:19141/FinalProject-DB/FilledTradeAdminServlet\">");
        out.println("<body>");
        out.println("<h1>" + title + "</h1>");

        // execute the statement and print out a table with the results
        out.println("<TABLE>");

		// make call to CORBA object and place in string
		String printThis = aResultSetCORBA.getSQLQueryResultSet(aQuery);
		out.println(printThis);
		
		printThis = aResultSetCORBA.getSQLQueryResultSet(aQuery2);
		out.println(printThis);
		
/*
<a href="javascript:document.location.reload();"
ONMOUSEOVER="window.status='Refresh'; return true"
ONMOUSEOUT="window.status='ah... that was good'">
<img src="images/refresh.jpg" width="130" height="46" border="0"></a>
*/  
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
	out.close();

    } // close doGet

} // close Audit Admin class