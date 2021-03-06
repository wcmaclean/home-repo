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
public final class myStruct implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String aString;

  public myStruct () {
    aString = "";
  }

  public myStruct (final java.lang.String aString) {
    this.aString = aString;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct SQLQueryResultSet.myStruct {");
    _ret.append("\n");
    _ret.append("java.lang.String aString=");
    _ret.append(aString != null?'\"' + aString + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof SQLQueryResultSet.myStruct) {
      final SQLQueryResultSet.myStruct obj = (SQLQueryResultSet.myStruct)o;
      boolean res = true;
      do {
        res = this.aString == obj.aString ||
         (this.aString != null && obj.aString != null && this.aString.equals(obj.aString));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
