
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
public class ResultSetSeqPOATie extends ResultSetSeqPOA {
  private SQLQueryResultSet.ResultSetSeqOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public ResultSetSeqPOATie (final SQLQueryResultSet.ResultSetSeqOperations _delegate) {
    this._delegate = _delegate;
  }

  public ResultSetSeqPOATie (final SQLQueryResultSet.ResultSetSeqOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public SQLQueryResultSet.ResultSetSeqOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final SQLQueryResultSet.ResultSetSeqOperations the_delegate) {
    this._delegate = the_delegate;
  }

  public org.omg.PortableServer.POA _default_POA () {
    if (_poa != null) {
      return _poa;
    } 
    else {
      return super._default_POA();
    }
  }

  /**
   * <pre>
   *   SQLQueryResultSet.aResultSetSeq getSQLQueryResultSet (in string aQuery);
   * </pre>
   */
  public SQLQueryResultSet.aResultSetStruct[] getSQLQueryResultSet (java.lang.String aQuery) {
    return this._delegate.getSQLQueryResultSet(aQuery);
  }

}
