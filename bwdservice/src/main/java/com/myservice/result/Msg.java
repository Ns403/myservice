package com.myservice.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回信息的判断
 */
@Data
public class Msg {
    private int code;
    private String msg;
    private Map<String, Object> resultMap = new HashMap<String, Object>();

    /**
     * 自定义返回类
     * 如需自定义返回状态请传
     *
     * @return
     */
    public static Msg sucess() {
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("操作成功");
        return result;
    }

    public static Msg fail() {
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("操作失败");
        return result;
    }

    public Msg add(String key, Object value) {
        this.getResultMap().put(key, value);
        return this;
//        return (Msg) this.getresultMap().put(key, value);
    }


}
