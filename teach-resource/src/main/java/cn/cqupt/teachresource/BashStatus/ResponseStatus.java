package cn.cqupt.teachresource.BashStatus;

/**
 * Created by YukunGeng on 2018/4/18.
 */
public class ResponseStatus {
    private String token;
    private int code;
    private String msg;
    private Object content;

    public ResponseStatus(String token, int code, String msg, Object content) {
        this.token = token;
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public ResponseStatus(int code, String msg, Object content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
