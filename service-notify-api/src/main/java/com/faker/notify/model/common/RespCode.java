package com.faker.notify.model.common;

/**
 * Created by faker on 17/5/26.
 */
public enum RespCode {
    SUCCESS(0, "成功"),
    Fail(500, "失败");

    private String value;
    private int code;

    private RespCode(int code, String value) {
        this.value = value;
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
