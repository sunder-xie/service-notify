package com.faker.notify.model.enums;

/**
 * Created by faker on 17/3/24.
 */
public enum  SmsStatusEnum {


    Tosend(0, "待发送"),
    Sended(1, "已发送"),
    Delivered(2, "已送达"),
    Failed(3, "发送失败");


    private Integer    code;


    private String value;


    private SmsStatusEnum(Integer code, String value){
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static SmsStatusEnum valueOf(Integer code) {
        for (SmsStatusEnum item : SmsStatusEnum.values()) {
            if (code.equals(item.getCode())) {
                return item;
            }
        }
        return null;
    }

    public static String getValueByCode(Integer code) {
        SmsStatusEnum item = valueOf(code);
        if (item != null) {
            return item.getValue();
        } else {
            return null;
        }
    }
}
