// Will MacLean
// CSPP 51024
// 
// SQLQueryResultSetImpl.java

import java.lang.Integer;
import java.lang.Long;
import SQLQueryResultSet.*;
import java.sql.*;


public class SQLQueryResultSetImpl 
	extends SQLQueryResultSet.ResultSetCORBAPOA 
{
	public String getSQLQueryResultSet(String aQuery)
	{

		// set up query objects
		ResultSet aResultSet = null;
		Statement aStatement = null;
		
		// make string
		String takeThis = new String();

		try
		{
			// get DB connection
			Connection aConnection = DBLink.getConnection();

			// execute query
			aStatement = aConnection.createStatement(); 
         aResultSet = aStatement.executeQuery(aQuery);
			
			// get metadata
			ResultSetMetaData aResultSetMetaData = aResultSet.getMetaData();
			
			// get column count
			int columnCount = aResultSetMetaData.getColumnCount();

			// put column names in array
			takeThis = takeThis + "<TR>";
			for(int i=1 ; i<=columnCount; i++){
System.out.println("got here 1");				
				takeThis = takeThis 	+ "<TD><B>" 
											+ aResultSetMetaData.getColumnName(i)
											+ "</TD></B>";									
			}
			takeThis = takeThis + "</TR>";
			
			// put ResultSet in array
			while(aResultSet.next()) {
System.out.println("got here 4");			
				takeThis = takeThis + "<TR>";
				for(int i=1; i<=columnCount; i++){
System.out.println("got here 5");				
					takeThis = takeThis 	+ "<TD>" 
												+ aResultSet.getString(i)
												+ "</TD>";
				}
				takeThis = takeThis + "</TR>";
			}
			
			// close DB stuff
			aStatement.close();
			aConnection.close();
			
		}
		catch(Exception e)
		{		
			e.printStackTrace();	
			return new String("Error: did not connect to DB");
		}
			
		// return the stuff
		return takeThis;
		//return "cheeze";	

	} // close getSQLQueryResultSet()
	
	public long getClSeqID(){
		// create empty return value 
		long returnThis = 0;
		
		
		// set up query objects
		ResultSet aResultSet = null;
		Statement aStatement = null;
		
		try
		{
			// get DB connection
			Connection aConnection = DBLink.getConnection();
			
			// setup retrieve query
			String aQuery = "SELECT * FROM SeqCount";

/*			
				"SeqCountKey INTEGER NOT NULL PRIMARY KEY, " +
				"SeqCountNum INTEGER NOT NULL" +
*/
			// execute query
			aStatement = aConnection.createStatement(); 
         aResultSet = aStatement.executeQuery(aQuery);
			
			// get metadata
			ResultSetMetaData aResultSetMetaData = aResultSet.getMetaData();
			
			// isolate the count in a long
			returnThis = Long.parseLong(aResultSet.getString(2));
			
			// add one
			returnThis = returnThis + Long.parseLong("1");
			
			// setup write query
			aQuery = "UPDATE SET SeqCountNum=" + returnThis + " WHERE SeqCountKey=1";

			// execute query
         aStatement.executeQuery(aQuery);

			// close DB stuff
			aStatement.close();
			aConnection.close();
			
		}
		catch(Exception e)
		{		
			e.printStackTrace();	
			return returnThis;
		}
			
		
		return returnThis;
	}


} // close class