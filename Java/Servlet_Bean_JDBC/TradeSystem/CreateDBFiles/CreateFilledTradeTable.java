import java.sql.*;

public class CreateFilledTradeTable{

  static String[] fakeTrades = {
      "(1,  2,  1, 10, 100, 12315627, 10, 1)",
      "(3,  4,  2, 50, 200, 98743428, 60, 2)",
      "(5,  1,  3, 75, 150, 54739875, 135, 3)",
  };



    public static void main(String[] args) {

	Connection aConnection = null;
	int iRowCount = 0;
	Statement stmt = null;

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
		catch( Exception e2 ) {}
	    }
	    return;
	} // end catch

	// to allow the program to be run more than once,
	// attempt to remove the table from the database
	try{
	    stmt.executeUpdate( "DROP TABLE FilledTrade" );
	    System.out.println("Table FilledTrade was removed.");
	}catch ( Exception e ) { /* don't care */ }

	// execute SQL commands 
	// to create table and insert data
	try{
	    String update = "CREATE TABLE FilledTrade (" + 
				"buyerID 		FLOAT NOT NULL, " +
				"sellerID 		FLOAT NOT NULL, " +
				"clSeqID 		FLOAT NOT NULL PRIMARY KEY, " +
				"quantity 		INTEGER NOT NULL, " +
				"price 			INTEGER NOT NULL, " +
				"mkTime 			FLOAT NOT NULL, " +
				"volume 			INTEGER NOT NULL, " +
				"totalTrades 	INTEGER NOT NULL" +
				")";

	    System.out.println(update);
	    stmt.executeUpdate(update);

	    System.out.println("Table FilledTrade was created.");

	    // Add some fake data
	    for (int i = 0; i < fakeTrades.length; i++){
		iRowCount += stmt.executeUpdate 
		    ("INSERT INTO FilledTrade VALUES " +  fakeTrades[i] );
	   }


	 }catch( Exception e ){
	    System.err.println("problem with SQL" );
	    System.err.println( e.getMessage() );
	}finally{
	    try { stmt.close(); }
	    catch( Exception e ) {}

	    try { aConnection.close(); }
	    catch( Exception e ) {}
	} // end finally clause

    } // end main
} // end class CreateFilledTradeTable