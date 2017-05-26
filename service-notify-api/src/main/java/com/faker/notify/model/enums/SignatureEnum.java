package com.faker.notify.model.enums;


/**
 * Created by faker on 17/3/22.
 */
public enum  SignatureEnum {


    Dogy(1, "汪星人");


    private Integer    code;


    private String value;


    private SignatureEnum(Integer code, String value){
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static SignatureEnum valueOf(Integer code) {
        for (SignatureEnum item : SignatureEnum.values()) {
            if (code.equals(item.getCode())) {
                return item;
            }
        }
        return null;
    }

    public static String getValueByCode(Integer code) {
        SignatureEnum item = valueOf(code);
        if (item != null) {
            return item.getValue();
        } else {
            return null;
        }
    }
}
