import java.sql.*;

public class CreateTradeTable{

/*
  static String[] fakeTrades = {
      "('+', 1,  1, 10, 100, 12315627)",
      "('-', 3,  2, 50, 200, 98743428)",
      "('+', 5,  3, 75, 150, 54739875)",
  };
*/
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
	    stmt.executeUpdate( "DROP TABLE Trade" );
	    System.out.println("Table Trade was removed.");
	}catch ( Exception e ) { /* don't care */ }

	// execute SQL commands 
	// to create table and insert data
	try{
	    String update = "CREATE TABLE Trade (" + 
				"limit 		VARCHAR(1) NOT NULL, " +
				"clientID 	FLOAT NOT NULL REFERENCES ClientData(ClientID), " +
				"clSeqID 	FLOAT NOT NULL PRIMARY KEY, " +
				"quantity 	INTEGER NOT NULL, " +
				"price 		INTEGER NOT NULL, " +
				"clTime 		FLOAT NOT NULL" +
				")";

	    System.out.println(update);
	    stmt.executeUpdate(update);

	    System.out.println("Table Trade was created.");
/*	    
	    // enter fake data
	    for (int i = 0; i < fakeTrades.length; i++){
				iRowCount += stmt.executeUpdate 
		    		("INSERT INTO Trade VALUES " +  fakeTrades[i] );
	    }
*/


	}catch( Exception e ){
	    System.err.println("problem with SQL");
	    System.err.println( e.getMessage() );
	}finally{
	    try { stmt.close(); }
	    catch( Exception e ) {}

	    try { aConnection.close(); }
	    catch( Exception e ) {}
	} // end finally clause

    } // end main
} // end class CreateTradeTable