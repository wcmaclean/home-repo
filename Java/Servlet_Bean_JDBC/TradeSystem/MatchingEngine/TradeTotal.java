import java.sql.*;
import java.lang.Long;
import java.lang.Integer;

public class TradeTotal{

	public int getTradeTotal(){
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
	    String requestSeqCount = 
	    	"SELECT TradeTotalNum FROM TradeTotal WHERE TradeTotalKey=1";

	    	// execute query and get SeqCount 	    	
			aResultSet = stmt.executeQuery(requestSeqCount);

			
//long tempLong = Long.parseLong(request.getParameter("clSeqID"));
			while(aResultSet.next()) {
				returnThis = Integer.parseInt(aResultSet.getString(1));
			}
			System.out.println(returnThis);
			// increment SeqCount 
			returnThis = returnThis+1;

	    // update database with new SeqCount 
	   stmt.executeUpdate(
	   	"UPDATE TradeTotal SET TradeTotalNum=" + returnThis + "WHERE TradeTotalKey=1");


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
		TradeTotal aTradeTotal = new TradeTotal();
		System.out.println(aTradeTotal.getTradeTotal());

    } // end main
} // end class CreateSeqCountTable