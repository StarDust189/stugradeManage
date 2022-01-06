package com.shixun.response;

import java.io.Serializable;

public class ResultResponse implements Serializable {
    private String statusCode;
    private String msg;
    private Object obj;

    public ResultResponse() {
    }

    @Override
    public String toString() {
        return "ResultResponse{" +
                "statusCode='" + statusCode + '\'' +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public ResultResponse(String statusCode, String msg, Object obj) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.obj = obj;
    }
}
