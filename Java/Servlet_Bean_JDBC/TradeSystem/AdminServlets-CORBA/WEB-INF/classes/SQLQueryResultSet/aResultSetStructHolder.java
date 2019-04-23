package SQLQueryResultSet;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "SQLQueryResultSet.idl"
 * <li> <b>IDL Name</b>      ::SQLQueryResultSet::aResultSetStruct
 * <li> <b>Repository Id</b> IDL:SQLQueryResultSet/aResultSetStruct:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct aResultSetStruct {
  ...
};
 * </pre>
 */
public final class aResultSetStructHolder implements org.omg.CORBA.portable.Streamable {
public SQLQueryResultSet.aResultSetStruct value;

public aResultSetStructHolder () {
}

public aResultSetStructHolder (final SQLQueryResultSet.aResultSetStruct _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = SQLQueryResultSet.aResultSetStructHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  SQLQueryResultSet.aResultSetStructHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return SQLQueryResultSet.aResultSetStructHelper.type();
}
}
