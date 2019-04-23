import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SQLQueryWithCORBAServlet extends HttpServlet {

	public void init()
	{
		// Initialize the ORB.
    		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

    		// Get the manager Id
		byte[] aSQLQueryResultSet_Id = "aSQLQueryResultSet_Manager".getBytes();

    		// Locate an SQL Querier. Give the full POA name and the servant ID.
		SQLQueryResultSet.ResultSetSeq aSQLQueryResultSet = 
			SQLQueryResultSet.ResultSetSeqHelper.bind(orb, "/SQLQueryResultSet_agent_poa", aSQLQueryResultSet_Id);

	}

	public void destroy()
	{

	}
		
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        String title = "SQL Query";
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
	out.print(response.encodeURL("SQLQueryWithCORBAServlet"));

        out.print("\" ");
        out.println("method=POST>");
        out.println("Enter an SQL query:");
	out.println("<input type=\"text\" size=100 name=\"aQuery\">");
	out.println("<br>");
        out.println("<br>");
        out.println("<input type=\"submit\" value=\"Go\" >");
        out.println("<input type=\"reset\" value=\"Clear\" >");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    } // close doGet

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
        throws IOException, ServletException
    {
        String aQuery = request.getParameter("aQuery");

	// set up database stuff
	Statement aStatement = null;
	ResultSet aResultSet = null;

	// start page stuff
         String title = "SQL Query Results via CORBA";

         out.println("<HTML><HEAD><TITLE>");
         out.println(title);
         out.println("</TITLE></HEAD><BODY>");
         out.println("<H1>" + title + "</H1>");

         String str = request.getParameter("str");


          // execute the statement and print out a table with the results
          out.println("<TABLE>");

	// make call to CORBA object and place in vector
	Vector aResultVector = aSQLQueryResultSet.getSQLQueryResultSet(aQuery);


// ***********************************************************
// This stuff is gonna look different with a <vector>
/* 

          PreparedStatement aPreparedStatement = aConnection.prepareStatement(aQuery);
          ResultSet aResultSet = aPreparedStatement.execute();
	  
	  ResultSetMetaData aResultSetMetaData = aResultSet.getMetaData();

	  // print headers
	  out.println("<TR>");
	  for(int i = 1; i<=aResultSetMetaData.getColumnCount(); i++){
		out.println(aResultSetMetaData.getColumnName(i));
	  }
	  out.println("</TR>");

	  // print the rest
          while(aResultSet.next()) {
            out.println("<TR>");
	    for(int i = 1; i<=aResultSetMetaData.getColumnCount(); i++){
            	out.println("<TD>");
		out.println(aResultSet.getString(i));
            	out.println("</TD>");
	    }
            out.println("</TR>");
          }

*/ 
// end of different looking stuff
// *************************************************************

         out.println("</BODY></HTML>");
         out.close();

    } // close doPost
} // close SQLQuery class