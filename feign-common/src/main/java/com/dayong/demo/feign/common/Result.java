package com.dayong.demo.feign.common;

public class Result<T> {
    int code;
    String msg;
    T data;
    Throwable cause;

    Result() {
        this.code = 200;
        this.msg = "操作成功！";
    }

    Result(T data) {
        this.code = 200;
        this.msg = "操作成功！";
        this.data = data;
    }

    Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    Result(int code, String msg, T data, Throwable throwable) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.cause = throwable;
    }

    public static Result success() {
        return new Result(null);
    }

    public static Result fail() {
        return new Result(500, "操作失败！", false, null);
    }

    public static Result fail(String errMsg) {
        return new Result(500, errMsg, false, null);
    }

    public static Result fail(String errMsg, Throwable throwable) {
        return new Result(500, errMsg, null, throwable);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }
}
