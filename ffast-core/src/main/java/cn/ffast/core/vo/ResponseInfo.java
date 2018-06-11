package cn.ffast.core.vo;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * service层执行的结果
 */
public class ResponseInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 返回的信息
     */
    protected String message;
    /**
     * 执行是否成功
     */
    protected Boolean success;

    protected Integer errNo;

    protected Map<String, Object> data = new HashMap<String, Object>();

    public ResponseInfo() {
    }

    public ResponseInfo(Boolean success) {
        this.success = success;
    }

    public ResponseInfo(Integer errNo, String message) {
        this.errNo = errNo;
        this.message = message;
        this.success = false;
    }

    public String toJSON() {
        JSONObject result = new JSONObject();
        result.put("message", message);
        result.put("success", success);
        result.put("data", data);
        result.put("errNo", errNo);
        return result.toString();
    }

    /**
     * 添加数据
     *
     * @param key
     * @param value
     */
    public ResponseInfo addData(String key, Object value) {
        data.put(key, value);
        return this;
    }

    public ResponseInfo setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public ResponseInfo setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public Integer getErrNo() {
        return errNo;
    }

    public ResponseInfo setErrNo(Integer errNo) {
        this.errNo = errNo;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public ResponseInfo setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }
}
