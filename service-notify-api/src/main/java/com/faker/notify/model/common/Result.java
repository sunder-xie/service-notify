package com.faker.notify.model.common;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by faker on 17/5/26.
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 7033872480882247295L;

    private int code;
    private String message;
    private T data;

    public Result() {

    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> createSuccess(String  message, T data) {
        return new Result<T>(RespCode.SUCCESS.getCode(), message, data);
    }

}
