import java.sql.*;

public class CreateClientTable{

  static String[] inventory = {
      "(1,  'Steve',  'Austin')",
      "(2,  'Arthur',  'Dent')",
      "(3,  'Ford',  'Prefect')",
      "(4,  'Tricia',  'McMillan')",
      "(5,  'Zaphod',  'Beeblebrox')",
  };

    public static void main(String[] args) {

	Connection aConnection = null;
	int iRowCount = 0;
	Statement stmt = null;

	// get a connection to the database
	aConnection = DBLink.getConnection();

	try{
	    stmt = con.createStatement();
	}catch ( Exception e){
	    System.err.println( "problems connecting");
	    System.err.println( e.getMessage() );
	    if( con != null){
		try { con.close(); }
		catch( Exception e2 ) {}
	    }
	    return;
	} // end catch

	// to allow the program to be run more than once,
	// attempt to remove the table from the database
	try{
	    stmt.executeUpdate( "DROP TABLE ClientData" );
	    System.out.println("Table ClientData was removed.");
	}catch ( Exception e ) { /* don't care */ }

	// execute SQL commands 
	// to create table and insert data
	try{
	    String update = "CREATE TABLE ClientData (" +
		"Client_ID  	INTEGER         NOT NULL PRIMARY KEY, "   +
		"Client_fName   VARCHAR(30)     NOT NULL, "   +
		"Client_lName   VARCHAR(30)     NOT NULL, "   +
		")";

	    System.out.println(update);
	    stmt.executeUpdate(update);

	    System.out.println("Table StoreData was created.");

	    for (int i = 0; i < inventory.length; i++){
		iRowCount += stmt.executeUpdate 
		    ("INSERT INTO ClientData VALUES " +  inventory[i] );
	    }

	    System.out.println( iRowCount + " Rows inserted into ClientData.");

	}( Exception e ){
	    System.err.println("problem with SQL sent to " + sURL + ":" );
	    System.err.println( e.getMessage() );
	}finally{
	    try { stmt.close(); }
	    catch( Exception e ) {}

	    try { con.close(); }
	    catch( Exception e ) {}
	} // end finally clause

    } // end main
} // end class CreateClientTable