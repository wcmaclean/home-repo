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
public final class myStructHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static SQLQueryResultSet.myStruct read (final org.omg.CORBA.portable.InputStream _input) {
    final SQLQueryResultSet.myStruct _result = new SQLQueryResultSet.myStruct();
    _result.aString = _input.read_string();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final SQLQueryResultSet.myStruct _vis_value) {
    _output.write_string((java.lang.String)_vis_value.aString);
  }

  public static void insert (final org.omg.CORBA.Any any, final SQLQueryResultSet.myStruct _vis_value) {
    any.insert_Streamable(new SQLQueryResultSet.myStructHolder(_vis_value));
  }

  public static SQLQueryResultSet.myStruct extract (final org.omg.CORBA.Any any) {
    SQLQueryResultSet.myStruct _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      SQLQueryResultSet.myStructHolder _vis_holder = new SQLQueryResultSet.myStructHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = SQLQueryResultSet.myStructHelper.read(any.create_input_stream());
    }
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          if (_initializing) {
            return _orb().create_recursive_tc(id());
          }
          _initializing = true;
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[1];
          members[0] = new org.omg.CORBA.StructMember("aString", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          _type = _orb().create_struct_tc(id(), "myStruct", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:SQLQueryResultSet/myStruct:1.0";
  }
}
