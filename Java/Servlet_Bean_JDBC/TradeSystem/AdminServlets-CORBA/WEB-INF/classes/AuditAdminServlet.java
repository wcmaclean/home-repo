import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import SQLQueryResultSet.*;
import java.lang.Integer;
import java.lang.reflect.Array;

public class AuditAdminServlet extends HttpServlet {

	SQLQueryResultSet.ResultSetCORBA aResultSetCORBA = null;
		
    public void doGet(HttpServletRequest request, 
		HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	// plan the query
	String aQuery = "SELECT * FROM Message ORDER BY type, clSeqID";



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
        String title = "Audit Admin";
        out.println("<title>" + title + "</title>");
        out.println("</head>");
		  //out.println("<META HTTP-EQUIV=\"REFRESH\" Content=\"10;URL=http://localhost:19141/FinalProject-DB/AuditAdminServlet\">");
        out.println("<body>");
        out.println("<h1>" + title + "</h1>");

        // execute the statement and print out a table with the results
        out.println("<TABLE>");

		// make call to CORBA object and place in string
		String printThis = aResultSetCORBA.getSQLQueryResultSet(aQuery);
		out.println(printThis);

  
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
	out.close();

    } // close doGet

} // close Audit Admin class