package SQLQueryResultSet;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "SQLQueryResultSet.idl"
 * <li> <b>IDL Name</b>      ::SQLQueryResultSet::aResultSetSeq
 * <li> <b>Repository Id</b> IDL:SQLQueryResultSet/aResultSetSeq:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef sequence&ltSQLQueryResultSet.aResultSetStruct&gt aResultSetSeq;
 * </pre>
 */
public final class aResultSetSeqHolder implements org.omg.CORBA.portable.Streamable {
public SQLQueryResultSet.aResultSetStruct[] value;

public aResultSetSeqHolder () {
}

public aResultSetSeqHolder (final SQLQueryResultSet.aResultSetStruct[] _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = SQLQueryResultSet.aResultSetSeqHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  SQLQueryResultSet.aResultSetSeqHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return SQLQueryResultSet.aResultSetSeqHelper.type();
}
}
