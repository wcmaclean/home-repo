package SQLQueryResultSet;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "SQLQueryResultSet.idl"
 * <li> <b>IDL Name</b>      ::SQLQueryResultSet::ResultSetSeq
 * <li> <b>Repository Id</b> IDL:SQLQueryResultSet/ResultSetSeq:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ResultSetSeq {
  ...
};
 * </pre>
 */
public interface ResultSetSeqOperations {
  /**
   * <pre>
   *   SQLQueryResultSet.aResultSetSeq getSQLQueryResultSet (in string aQuery);
   * </pre>
   */
  public SQLQueryResultSet.aResultSetStruct[] getSQLQueryResultSet (java.lang.String aQuery);

}
