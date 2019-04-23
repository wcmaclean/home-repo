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
public final class ResultSetSeqHolder implements org.omg.CORBA.portable.Streamable {
public SQLQueryResultSet.ResultSetSeq value;

public ResultSetSeqHolder () {
}

public ResultSetSeqHolder (final SQLQueryResultSet.ResultSetSeq _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = SQLQueryResultSet.ResultSetSeqHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  SQLQueryResultSet.ResultSetSeqHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return SQLQueryResultSet.ResultSetSeqHelper.type();
}
}
