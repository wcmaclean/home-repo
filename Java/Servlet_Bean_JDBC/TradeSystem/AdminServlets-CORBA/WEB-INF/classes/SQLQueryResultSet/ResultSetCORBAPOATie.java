
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
public class ResultSetCORBAPOATie extends ResultSetCORBAPOA {
  private SQLQueryResultSet.ResultSetCORBAOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public ResultSetCORBAPOATie (final SQLQueryResultSet.ResultSetCORBAOperations _delegate) {
    this._delegate = _delegate;
  }

  public ResultSetCORBAPOATie (final SQLQueryResultSet.ResultSetCORBAOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public SQLQueryResultSet.ResultSetCORBAOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final SQLQueryResultSet.ResultSetCORBAOperations the_delegate) {
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
   *   string getSQLQueryResultSet (in string aQuery);
   * </pre>
   */
  public java.lang.String getSQLQueryResultSet (java.lang.String aQuery) {
    return this._delegate.getSQLQueryResultSet(aQuery);
  }

  /**
   * <pre>
   *   long long getClSeqID ();
   * </pre>
   */
  public long getClSeqID () {
    return this._delegate.getClSeqID();
  }

}
