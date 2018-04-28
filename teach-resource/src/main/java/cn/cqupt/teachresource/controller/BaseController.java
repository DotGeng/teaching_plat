package cn.cqupt.teachresource.controller;

import cn.cqupt.teachresource.BaseParam.BaseCode;
import cn.cqupt.teachresource.BashStatus.ResponseStatus;

/**
 * Created by YukunGeng on 2018/4/18.
 */
public class BaseController {
    public ResponseStatus success(String token, String msg, Object content) {
        return new ResponseStatus(token, BaseCode.SUCCES_CODE, msg, content);
    }

    public ResponseStatus success(String msg, Object content) {
        return new ResponseStatus(BaseCode.SUCCES_CODE, msg, content);
    }

    public ResponseStatus sucess(String msg) {
        return new ResponseStatus(BaseCode.SUCCES_CODE, msg);
    }

    public ResponseStatus error(String msg) {
        return new ResponseStatus(BaseCode.ERROR_CODE, msg, "");
    }
}
