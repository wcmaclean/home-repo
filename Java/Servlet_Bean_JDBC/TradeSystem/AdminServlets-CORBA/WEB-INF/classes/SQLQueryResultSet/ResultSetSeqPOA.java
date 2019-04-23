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
public abstract class ResultSetSeqPOA extends org.omg.PortableServer.Servant implements 
org.omg.CORBA.portable.InvokeHandler, SQLQueryResultSet.ResultSetSeqOperations {

  public SQLQueryResultSet.ResultSetSeq _this () {
   return SQLQueryResultSet.ResultSetSeqHelper.narrow(super._this_object());
  }

  public SQLQueryResultSet.ResultSetSeq _this (org.omg.CORBA.ORB orb) {
    return SQLQueryResultSet.ResultSetSeqHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:SQLQueryResultSet/ResultSetSeq:1.0"
  };

  private static java.util.Dictionary _methods = new java.util.Hashtable();

  static {
    _methods.put("getSQLQueryResultSet", new int[] { 0, 0 });
  }

  public org.omg.CORBA.portable.OutputStream _invoke (java.lang.String opName,
                                                      org.omg.CORBA.portable.InputStream _input,
                                                      org.omg.CORBA.portable.ResponseHandler handler) {
    int[] method = (int[]) _methods.get(opName);
    if (method == null) {
      throw new org.omg.CORBA.BAD_OPERATION();
    }
    switch (method[0]) {
      case 0: {
        return SQLQueryResultSet.ResultSetSeqPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION();
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (SQLQueryResultSet.ResultSetSeqOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
  org.omg.CORBA.portable.OutputStream _output = null;
  {
    switch (_method_id) {
    case 0: {
      java.lang.String aQuery;
      aQuery = _input.read_string();
      SQLQueryResultSet.aResultSetStruct[] _result = _self.getSQLQueryResultSet(aQuery);
      _output = _handler.createReply();
      SQLQueryResultSet.aResultSetSeqHelper.write(_output, _result);
      return _output;
    }
    }
    throw new org.omg.CORBA.BAD_OPERATION();
  }
  }
}
