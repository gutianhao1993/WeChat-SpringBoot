package com.yaao.util;

/**
 * Json数据类
 *
 * @author gutianhao
 */
public class JsonResult {
    public static final int SUCCESS = 1;
    public static final int ERROR = 0;
    /**
     * 状态:(SUCCESS,ERROR)
     */
    private int state;
    /**
     * 状态信息
     */
    private String message;
    /**
     * 具体数据
     */
    private Object data;

    public JsonResult() {
        state = SUCCESS;
    }

    public JsonResult(String message) {
        this();
        this.message = message;
    }

    public JsonResult(Object data) {
        this();
        this.data = data;
    }

    public JsonResult(Throwable exp) {
        state = ERROR;
        this.message = exp.getMessage();
    }

    public int getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
