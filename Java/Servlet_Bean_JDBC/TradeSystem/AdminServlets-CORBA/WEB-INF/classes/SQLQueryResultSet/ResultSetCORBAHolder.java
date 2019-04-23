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
public final class ResultSetCORBAHolder implements org.omg.CORBA.portable.Streamable {
public SQLQueryResultSet.ResultSetCORBA value;

public ResultSetCORBAHolder () {
}

public ResultSetCORBAHolder (final SQLQueryResultSet.ResultSetCORBA _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = SQLQueryResultSet.ResultSetCORBAHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  SQLQueryResultSet.ResultSetCORBAHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return SQLQueryResultSet.ResultSetCORBAHelper.type();
}
}
