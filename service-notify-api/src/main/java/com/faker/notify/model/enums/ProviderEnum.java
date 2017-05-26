package com.faker.notify.model.enums;


/**
 * Created by faker on 17/3/22.
 */
public enum ProviderEnum {

    Alidayu(1, "阿里大鱼");

    private Integer    code;


    private String value;


    private ProviderEnum(Integer code, String value){
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static ProviderEnum valueOf(Integer code) {
        for (ProviderEnum item : ProviderEnum.values()) {
            if (code.equals(item.getCode())) {
                return item;
            }
        }
        return null;
    }

    public static String getValueByCode(Integer code) {
        ProviderEnum item = valueOf(code);
        if (item != null) {
            return item.getValue();
        } else {
            return null;
        }
    }
}
