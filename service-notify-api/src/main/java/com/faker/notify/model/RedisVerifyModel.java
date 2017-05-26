package com.faker.notify.model;

import java.io.Serializable;

/**
 * Created by faker on 17/4/1.
 */
public class RedisVerifyModel implements Serializable {
    private static final long serialVersionUID = 4873734960137474715L;
    private String verifyCode;
    private Integer retryLimit;
    private String targetPhone;
    private String key;
    private Integer currentRetry = 0;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTargetPhone() {
        return targetPhone;
    }

    public void setTargetPhone(String targetPhone) {
        this.targetPhone = targetPhone;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Integer getRetryLimit() {
        return retryLimit;
    }

    public void setRetryLimit(Integer retryLimit) {
        this.retryLimit = retryLimit;
    }

    public Integer getCurrentRetry() {
        return currentRetry;
    }

    public void setCurrentRetry(Integer currentRetry) {
        this.currentRetry = currentRetry;
    }
}
