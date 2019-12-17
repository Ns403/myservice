package com.myservice.result;

import lombok.Data;
import lombok.Getter;

import java.util.regex.PatternSyntaxException;
/**
 * @author 10479
 */
@Getter
public enum ResultEnum {
    /**
     * 返回信息
     */
    REQUEST_OK(0,"请求成功");
    private int code;
    private String msg;
    private Object data;

    ResultEnum(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    ResultEnum() {
    }

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Msg wrap(Object object) {
        Msg msg = new Msg();
        msg.setCode(ResultEnum.REQUEST_OK.getCode());
        msg.setMsg(ResultEnum.REQUEST_OK.getMsg());
        if (null != object) {
            msg.setData(object);
        }
        return msg;
    }
    public ResultEnum result(){
        return this;
    }
    public Msg result(int code ,String msg){
        return new Msg(code,msg);
    }
}
