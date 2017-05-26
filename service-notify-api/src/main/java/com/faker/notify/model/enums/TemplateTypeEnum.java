package com.faker.notify.model.enums;


/**
 * Created by faker on 17/3/24.
 */
public enum TemplateTypeEnum {

    Normal(1, "文本模板"),
    Radio(2, "语音模板");

    private Integer code;


    private String value;


    private TemplateTypeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static TemplateTypeEnum valueOf(Integer code) {
        for (TemplateTypeEnum item : TemplateTypeEnum.values()) {
            if (code.equals(item.getCode())) {
                return item;
            }
        }
        return null;
    }

    public static String getValueByCode(Integer code) {
        TemplateTypeEnum item = valueOf(code);
        if (item != null) {
            return item.getValue();
        } else {
            return null;
        }
    }
}
