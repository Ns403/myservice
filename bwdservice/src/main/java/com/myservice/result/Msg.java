package com.myservice.result;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 返回信息的判断
 */
@Data
public class Msg {
    private int code;
    private String msg;
    private Integer total;
    private Map<String, Object> resultMap = new HashMap<>();
    private List rows = new ArrayList<>();

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

    public Msg addMap(String key, Object value) {
        this.setTotal(1);
        this.getResultMap().put(key, value);
        return this;
//        return (Msg) this.getresultMap().put(key, value);
    }
    public Msg addList(List value) {
        this.setTotal(200);
        this.rows=value;
        return this;
    }


}
