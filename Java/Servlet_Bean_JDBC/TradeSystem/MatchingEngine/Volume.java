import java.sql.*;
import java.lang.Long;
import java.lang.Integer;

public class Volume{

	public int getVolume(int sold){
		Connection aConnection = null;
		int iRowCount = 0;
		Statement stmt = null;
		int returnThis =0;
		ResultSet aResultSet = null;

		// get a connection to the database
		//aConnection = DBLink.getConnection();

	try{
			aConnection = DBLink.getConnection();
	    	stmt = aConnection.createStatement();
	}catch ( Exception e){
	    	System.err.println( "problems connecting");
	    	System.err.println( e.getMessage() );
	    	if( aConnection != null){
			try { aConnection.close(); }
				catch( Exception e2 ) { return returnThis; }
	    	}
	   	return returnThis;
	} // end catch
	// execute SQL commands 
	// to create table and insert data
	try{
	    String requestVolume = 
	    	"SELECT VolNum FROM Volume WHERE VolKey=1";

	    	// execute query and get SeqCount 	    	
			aResultSet = stmt.executeQuery(requestVolume);

			
//long tempLong = Long.parseLong(request.getParameter("clSeqID"));
			while(aResultSet.next()) {
				returnThis = Integer.parseInt(aResultSet.getString(1));
			}
			System.out.println(returnThis);
			// increment SeqCount 
			returnThis = returnThis+sold;

	    // update database with new SeqCount 
	   stmt.executeUpdate(
	   	"UPDATE Volume SET VolNum=" + returnThis + "WHERE VolKey=1");


	 	}catch( Exception e ){
	    	System.err.println("problem with SQL" );
	    	System.err.println( e.getMessage() );
		}finally{
	    	try { stmt.close(); }
	    	catch( Exception e ) {}

	    	try { aConnection.close(); }
	    	catch( Exception e ) {}
		} // end finally clause	
		
		return returnThis;
	}

    public static void main(String[] args) {
		Volume aVolume = new Volume();
		System.out.println(aVolume.getVolume(2));

    } // end main
} // end class Volume