// Will MacLean
// CSPP 51024
// 
// SQLQueryResultSetImpl.java

import java.util.Vector;
import java.lang.Integer;

public class SQLQueryResultSetImpl extends SQLQueryResultSet.ResultSetSeqPOA {
    
	public Vector getSQLQueryResultSet(String aQuery){

	// set up resultset object
	ResultSet aResultSet = null;

	try{
		// get DB connection
		Connection aConnection = DBLink.getConnection();

		// set up and execute query
          	PreparedStatement aPreparedStatement = aConnection.prepareStatement(aQuery);
          	ResultSet aResultSet = aPreparedStatement.execute();

		// close DB stuff
		aPreparedStatement.close();
		aConnection.close();
	}
	catch(Exception e)
	{		
		e.printStackTrace();	
		return new Vector();		
	}

	// get metadata
	ResultSetMetaData aResultSetMetaData = aResultSet.getMetaData();

	// create a vector
	Vector aVectorOfResultSet = new Vector();

	// get column count, add to Vector
	int columnCount = aResultSetMetaData.getColumnCount();
	aVectorOfResultSet.addElement(Integer.toString(columnCount));

	// from metadata, place column names into vector
	for(int i = 1; i<=columnCount; i++){
		aVectorOfResultSet.addElement(aResultSetMetaData.getColumnName(i));
	}

	// add each entry piece of resultset to vector
	while(aResultSet.next()) {
	for(int i = 1; i<=columnCount; i++){
		aVectorOfResultSet.addElement(aResultSet.getString(i));
	}

	// return vector	
	return aVectorOfResultSet;

}