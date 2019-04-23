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
public final class aResultSetSeqHelper {
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static SQLQueryResultSet.aResultSetStruct[] read (final org.omg.CORBA.portable.InputStream _input) {
    SQLQueryResultSet.aResultSetStruct[] result;
    final int $length0 = _input.read_long();
    if($length0 != 0) {
    result = new SQLQueryResultSet.aResultSetStruct[$length0];
    for (int $counter1 = 0; $counter1 < $length0; $counter1++) {
      result[$counter1] = SQLQueryResultSet.aResultSetStructHelper.read(_input);
    }
    }
    else {
      result = SQLQueryResultSet.aResultSetSeqHelper.EMPTY_LIST;
    }
    return result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final SQLQueryResultSet.aResultSetStruct[] _vis_value) {
    if(_vis_value == null){
      throw new org.omg.CORBA.BAD_PARAM("Null parameter");
    }
    _output.write_long(_vis_value.length);
    for (int $counter2 = 0;  $counter2 < _vis_value.length; $counter2++) {
      if (_vis_value[$counter2] == null) {
        throw new org.omg.CORBA.BAD_PARAM("Invalid array length");
      }
      SQLQueryResultSet.aResultSetStructHelper.write(_output, _vis_value[$counter2]);
    }
  }

  public static void insert (final org.omg.CORBA.Any any, final SQLQueryResultSet.aResultSetStruct[] _vis_value) {
    any.type(SQLQueryResultSet.aResultSetSeqHelper.type());
    any.insert_Streamable(new SQLQueryResultSet.aResultSetSeqHolder(_vis_value));
  }

  public static SQLQueryResultSet.aResultSetStruct[] extract (final org.omg.CORBA.Any any) {
    SQLQueryResultSet.aResultSetStruct[] _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      SQLQueryResultSet.aResultSetSeqHolder _vis_holder = new SQLQueryResultSet.aResultSetSeqHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    } else {
      _vis_value = SQLQueryResultSet.aResultSetSeqHelper.read(any.create_input_stream());
    }
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          org.omg.CORBA.TypeCode originalType = _orb().create_sequence_tc(0, SQLQueryResultSet.aResultSetStructHelper.type());
          _type = _orb().create_alias_tc(id(), "aResultSetSeq", originalType);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:SQLQueryResultSet/aResultSetSeq:1.0";
  }
  public final static SQLQueryResultSet.aResultSetStruct[] EMPTY_LIST = {};
}
