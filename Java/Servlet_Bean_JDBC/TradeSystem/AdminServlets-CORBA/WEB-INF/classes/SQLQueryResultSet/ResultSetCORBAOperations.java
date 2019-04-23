package SQLQueryResultSet;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "SQLQueryResultSet.idl"
 * <li> <b>IDL Name</b>      ::SQLQueryResultSet::ResultSetCORBA
 * <li> <b>Repository Id</b> IDL:SQLQueryResultSet/ResultSetCORBA:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface ResultSetCORBA {
  ...
};
 * </pre>
 */
public interface ResultSetCORBAOperations {
  /**
   * <pre>
   *   string getSQLQueryResultSet (in string aQuery);
   * </pre>
   */
  public java.lang.String getSQLQueryResultSet (java.lang.String aQuery);

  /**
   * <pre>
   *   long long getClSeqID ();
   * </pre>
   */
  public long getClSeqID ();

}
