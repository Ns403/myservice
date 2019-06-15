package com.myservice.result;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param <T>
 * @ClassName: ResponseEntity
 * @Description: 客户端响应公共实体类
 */
@ToString
@Data
@Accessors(chain = true)
public class ResponseEntity<T> {
    /**
     * 通配符
     **/
    public static final String WILDCARD_ALL = "*";
    /**
     * 响应状态码
     **/
    private volatile String statusCode = StatusCode.OK.getStatusCode();
    /**
     * 响应状态码对应的提示信息
     **/
    private volatile String statusMessage = StatusCode.OK.getStatusMessage();

    /**
     * 响应内容
     **/
    private volatile T responseContent ;
    /**
     * EasyUI数据网格需要的字段
     */
    private volatile Integer total;
    /**
     * 响应的表格数据
     */
    private volatile T rows;


    public ResponseEntity() {
    }


    public ResponseEntity(final String statusCode, final String statusMessage) {
        this(statusCode, statusMessage, null);
    }

    public ResponseEntity(final String statusCode, final String statusMessage, final T responseContent) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.responseContent = responseContent;
    }

    public ResponseEntity(String statusCode, String statusMessage, Integer total, T rows) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.total = total;
        this.rows = rows;
    }

    public static ResponseEntity empty() {
        return new ResponseEntity();
    }

    /**
     * 成功请求,成功状态码自行指定
     *
     * @param ok
     * @param message
     * @return
     */
    public static ResponseEntity ok(final StatusCode ok, final String message) {
        return new ResponseEntity(ok.getStatusCode(), message);
    }

    public static ResponseEntity ok() {
        return new ResponseEntity(StatusCode.OK.getStatusCode(), StatusCode.OK.getStatusMessage());
    }

    public static ResponseEntity ok(final String message) {
        return new ResponseEntity(StatusCode.OK.getStatusCode(), message);
    }
    /**
     * 失败请求,失败状态码自行指定
     *
     * @param fail
     * @param message
     * @return
     */
    public static ResponseEntity fail(final StatusCode fail, final String message) {
        return new ResponseEntity(fail.getStatusCode(), message);
    }

    /**
     * 添加数据使用
     */
    public ResponseEntity add(final String key, final Object value) {
        if (null == this.responseContent) {
            this.responseContent = (T) new HashMap<String, Object>();
            Map<String, Object> content = (Map<String, Object>) this.responseContent;
            content.put(key, value);
            return this;
        }
        if (!(this.responseContent instanceof Map)) {
            return this;
        }
        ((Map) this.responseContent).put(key, value);
        return this;
    }

    /**
     * 返回easyUI的数据
     */
    public ResponseEntity<T> add(final Integer total, final List<Object> rows) {
        if (null == this.rows) {
            this.rows = (T) new ArrayList<Object>();
            List<Object> list = (List<Object>) this.rows;
            list.addAll(rows);
            this.total = total;
            return this;
        }
        if (!(this.rows instanceof List)) {
            return this;
        }
        this.total = total;
        ((List) this.rows).addAll(rows);
        return this;
    }


    /**
     * 定义指定的响应码与响应信息
     */
    public enum StatusCode {
        /**
         * [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
         **/
        OK("200", "请求成功"),
        ERROR("500", "请求失败");

        private final String statusCode;
        private final String statusMessage;

        StatusCode(String statusCode, String statusMessage) {
            this.statusCode = statusCode;
            this.statusMessage = statusMessage;
        }

        public String getStatusMessage() {
            return statusMessage;
        }

        public String getStatusCode() {
            return statusCode;
        }

    }


}
