// Based on code from Prof. Siegel's CSPP51037
//
// Encapsulates Oracle database connection

import java.sql.*;

public class DBLink{
    public static Connection getConnection(){
	Connection aConnection = null;

	// change the driver with this variable
	String sDriver = "oracle.jdbc.OracleDriver";
	
	// change the database server with this variable
	String sURL = "jdbc:oracle:thin:@limani.cs.uchicago.edu:1521:cs51024";

	// change the physical database within the server using this variable
	String sUsername = "wmaclean";
	String sPassword = "cs366201";

	try{   
	    Class.forName( sDriver ).newInstance();
	}catch( Exception e ){  
	    System.err.println("Failed to load current driver.");
	    return null;
	} 
	
	try{
	    aConnection = DriverManager.getConnection ( sURL,
						sUsername,
						sPassword);
	}catch ( Exception e){
	    System.err.println( "problems connecting to " +
				sURL + ":" );
	    System.err.println( e.getMessage() );

	    if( aConnection != null){
		try { aConnection.close(); }
		catch( Exception e2 ) {}
	    }
	    return null;
	}
	
	return(aConnection);
    }
}
