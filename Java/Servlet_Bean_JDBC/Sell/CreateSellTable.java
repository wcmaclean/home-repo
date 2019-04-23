import java.sql.*;

public class CreateSellTable{


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
	    stmt.executeUpdate( "DROP TABLE Sell" );
	    System.out.println("Table Sell was removed.");
	}catch ( Exception e ) { /* don't care */ }

	// execute SQL commands 
	// to create table and insert data
	try{
	    String update = "CREATE TABLE Sell (" +
				"SellID VARCHAR(30) NOT NULL PRIMARY KEY, " +
				"ClientID BIGINT NOT NULL, " +
				"ClSeqID BIGINT, " +
				"Quantity INTEGER NOT NULL, " +
				"Price INTEGER NOT NULL, " +
				"ClTime BIGINT NOT NULL" +
				)";

	    System.out.println(update);
	    stmt.executeUpdate(update);

	    System.out.println("Table Sell was created.");


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
} // end class CreateSellTable