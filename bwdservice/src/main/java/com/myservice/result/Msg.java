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
    private Object data;

    public Msg() {
    }

    public Msg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
