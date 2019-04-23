import java.sql.*;

public class CreateMessageTable{

  static String[] fakeMessages = {
      "('ACK', '+', 1,  1, 10, 100, 12315627)",
      "('ACK', '-', 3,  2, 50, 200, 98743428)",
      "('NACK', '+', 5,  3, 75, 150, 54739875)",
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
	    stmt.executeUpdate( "DROP TABLE Message" );
	    System.out.println("Table Message was removed.");
	}catch ( Exception e ) { /* don't care */ }

	// execute SQL commands 
	// to create table and insert data
	try{
	    String update = "CREATE TABLE Message (" + 
				"type VARCHAR(30) NOT NULL, " +
				"limit VARCHAR(1) NOT NULL, " +
				"clientID FLOAT NOT NULL REFERENCES ClientData(ClientID), " +
				"clSeqID FLOAT, " +
				"quantity INTEGER NOT NULL, " +
				"price INTEGER NOT NULL, " +
				"clTime FLOAT NOT NULL" +
				")";

	    System.out.println(update);
	    stmt.executeUpdate(update);

	    System.out.println("Table Message was created.");

	    // enter fake data
	    for (int i = 0; i < fakeMessages.length; i++){
				iRowCount += stmt.executeUpdate 
		    		("INSERT INTO Message VALUES " +  fakeMessages[i] );
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
} // end class CreateMessageTable