package com.faker.notify.model;


import com.faker.notify.model.enums.SmsStatusEnum;

/**
 * Created by faker on 17/3/31.
 */
public class SendResult {
    private SmsStatusEnum status = SmsStatusEnum.Failed;
    private String failReason = "";
    private String SerialNo;

    public String getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(String serialNo) {
        SerialNo = serialNo;
    }

    public SmsStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SmsStatusEnum status) {
        this.status = status;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }
}
