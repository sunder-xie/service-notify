package com.faker.notify.model;

/**
 * Created by faker on 17/3/28.
 */
public class SmsMessage extends VerifyCodeParam {
    private static final long serialVersionUID = -7559657885099527692L;

    private Boolean isVerifyCode = false;

    public Boolean getVerifyCode() {
        return isVerifyCode;
    }

    public void setVerifyCode(Boolean verifyCode) {
        isVerifyCode = verifyCode;
    }

}
