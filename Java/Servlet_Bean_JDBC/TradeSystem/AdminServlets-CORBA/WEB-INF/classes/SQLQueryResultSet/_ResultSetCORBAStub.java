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
public class _ResultSetCORBAStub extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements SQLQueryResultSet.ResultSetCORBA {
  final public static java.lang.Class _opsClass = SQLQueryResultSet.ResultSetCORBAOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:SQLQueryResultSet/ResultSetCORBA:1.0"
  };

  /**
   * <pre>
   *   string getSQLQueryResultSet (in string aQuery);
   * </pre>
   */
  public java.lang.String getSQLQueryResultSet (java.lang.String aQuery) {

    while (true) {
    if (!_is_local()) {
      org.omg.CORBA.portable.OutputStream _output = null;
      org.omg.CORBA.portable.InputStream  _input  = null;
      java.lang.String _result;
      try {
        _output = this._request("getSQLQueryResultSet", true);
        _output.write_string((java.lang.String)aQuery);
        _input = this._invoke(_output);
        _result = _input.read_string();
        return _result;
      }
      catch (org.omg.CORBA.portable.ApplicationException _exception) {
        java.lang.String _exception_id = _exception.getId();
        throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
      }
      catch (org.omg.CORBA.NO_RESPONSE _vis_nm ) {
       if(_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
              return null;

    }
    throw _vis_nm;
    }
    catch (org.omg.CORBA.portable.RemarshalException _exception) {
    continue;
    }
    finally {
    this._releaseReply(_input);
    }
    } else {
    SQLQueryResultSet.ResultSetCORBAOperations _self = null;
    final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getSQLQueryResultSet", _opsClass);
    if (_so == null) {
    continue;
    }
    try {
    _self = (SQLQueryResultSet.ResultSetCORBAOperations)_so.servant;
    }catch (java.lang.ClassCastException _vis_ce) {
    org.omg.CORBA.portable.OutputStream _output = null;
    org.omg.CORBA.portable.InputStream  _input  = null;
    java.lang.String _result;
    try {
    _output = _orb().create_output_stream();
    final org.omg.CORBA.portable.OutputStream _response_output = _orb().create_output_stream();
    final org.omg.CORBA.portable.OutputStream _response_ex_output = _orb().create_output_stream();
    com.inprise.vbroker.orb.VBResponseHandler _vis_vbr = com.inprise.vbroker.orb.VBResponseHandler.getResponseHandler(_response_output,_response_ex_output);
    _output.write_string((java.lang.String)aQuery);
    org.omg.CORBA.portable.OutputStream _result_output = (((org.omg.CORBA.portable.InvokeHandler)_so.servant)._invoke("getSQLQueryResultSet",_output.create_input_stream(),_vis_vbr));
    _input = _result_output.create_input_stream();

    _result = _input.read_string();
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
    }
    return _result;
    } catch (java.lang.RuntimeException _vis_re) {
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)_vis_re);
    }
    throw _vis_re;
    } catch (java.lang.Error _vis_err) {
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)_vis_err);
    }
    throw _vis_err;
    }finally {
    _servant_postinvoke(_so);
    this._releaseReply(_input);
    }
    }
    try {
    java.lang.String _ret = _self.getSQLQueryResultSet(aQuery);
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
    }
    return _ret;
    } catch (java.lang.RuntimeException _vis_re) {
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)_vis_re);
    }
    throw _vis_re;
    } catch (java.lang.Error _vis_err) {
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)_vis_err);
    }
    throw _vis_err;
    } finally {
    _servant_postinvoke(_so);
    }

    }
    }
  }

  /**
   * <pre>
   *   long long getClSeqID ();
   * </pre>
   */
  public long getClSeqID () {

    while (true) {
    if (!_is_local()) {
      org.omg.CORBA.portable.OutputStream _output = null;
      org.omg.CORBA.portable.InputStream  _input  = null;
      long _result;
      try {
        _output = this._request("getClSeqID", true);
        _input = this._invoke(_output);
        _result = _input.read_longlong();
        return _result;
      }
      catch (org.omg.CORBA.portable.ApplicationException _exception) {
        java.lang.String _exception_id = _exception.getId();
        throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
      }
      catch (org.omg.CORBA.NO_RESPONSE _vis_nm ) {
       if(_vis_nm.minor == (org.omg.CORBA.OMGVMCID.value | 99)) {
            return 0L;

    }
    throw _vis_nm;
    }
    catch (org.omg.CORBA.portable.RemarshalException _exception) {
    continue;
    }
    finally {
    this._releaseReply(_input);
    }
    } else {
    SQLQueryResultSet.ResultSetCORBAOperations _self = null;
    final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getClSeqID", _opsClass);
    if (_so == null) {
    continue;
    }
    try {
    _self = (SQLQueryResultSet.ResultSetCORBAOperations)_so.servant;
    }catch (java.lang.ClassCastException _vis_ce) {
    org.omg.CORBA.portable.OutputStream _output = null;
    org.omg.CORBA.portable.InputStream  _input  = null;
    long _result;
    try {
    _output = _orb().create_output_stream();
    final org.omg.CORBA.portable.OutputStream _response_output = _orb().create_output_stream();
    final org.omg.CORBA.portable.OutputStream _response_ex_output = _orb().create_output_stream();
    com.inprise.vbroker.orb.VBResponseHandler _vis_vbr = com.inprise.vbroker.orb.VBResponseHandler.getResponseHandler(_response_output,_response_ex_output);
    org.omg.CORBA.portable.OutputStream _result_output = (((org.omg.CORBA.portable.InvokeHandler)_so.servant)._invoke("getClSeqID",_output.create_input_stream(),_vis_vbr));
    _input = _result_output.create_input_stream();

    _result = _input.read_longlong();
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
    }
    return _result;
    } catch (java.lang.RuntimeException _vis_re) {
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)_vis_re);
    }
    throw _vis_re;
    } catch (java.lang.Error _vis_err) {
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)_vis_err);
    }
    throw _vis_err;
    }finally {
    _servant_postinvoke(_so);
    this._releaseReply(_input);
    }
    }
    try {
    long _ret = _self.getClSeqID();
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).normalCompletion();
    }
    return _ret;
    } catch (java.lang.RuntimeException _vis_re) {
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)_vis_re);
    }
    throw _vis_re;
    } catch (java.lang.Error _vis_err) {
    if (_so instanceof org.omg.CORBA.portable.ServantObjectExt) {
    ((org.omg.CORBA.portable.ServantObjectExt)_so).exceptionalCompletion((Throwable)_vis_err);
    }
    throw _vis_err;
    } finally {
    _servant_postinvoke(_so);
    }

    }
    }
  }

}
