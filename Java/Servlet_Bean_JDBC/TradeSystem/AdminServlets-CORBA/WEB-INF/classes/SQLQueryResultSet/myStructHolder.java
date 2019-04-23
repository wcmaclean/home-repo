package SQLQueryResultSet;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "SQLQueryResultSet.idl"
 * <li> <b>IDL Name</b>      ::SQLQueryResultSet::myStruct
 * <li> <b>Repository Id</b> IDL:SQLQueryResultSet/myStruct:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct myStruct {
  ...
};
 * </pre>
 */
public final class myStructHolder implements org.omg.CORBA.portable.Streamable {
public SQLQueryResultSet.myStruct value;

public myStructHolder () {
}

public myStructHolder (final SQLQueryResultSet.myStruct _vis_value) {
  this.value = _vis_value;
}

public void _read (final org.omg.CORBA.portable.InputStream input) {
  value = SQLQueryResultSet.myStructHelper.read(input);
}

public void _write (final org.omg.CORBA.portable.OutputStream output) {
  SQLQueryResultSet.myStructHelper.write(output, value);
}

public org.omg.CORBA.TypeCode _type () {
  return SQLQueryResultSet.myStructHelper.type();
}
}
