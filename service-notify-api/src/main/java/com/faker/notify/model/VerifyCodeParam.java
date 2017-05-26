package com.faker.notify.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by faker on 17/3/17.
 */
@ApiModel(value = "验证码实体")
public class VerifyCodeParam extends SmsParam {
    @ApiModelProperty(value = "有效期")
    private Integer expired;
    @ApiModelProperty(value = "最大无效次数")
    private Integer invalidations;
    @ApiModelProperty(value = "验证码最小长度")
    private Integer minLength;
    @ApiModelProperty(value = "验证码最大长度")
    private Integer maxLength;
    @ApiModelProperty(value = "标识验证场景的key")
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getExpired() {
        return expired;
    }

    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    public Integer getInvalidations() {
        return invalidations;
    }

    public void setInvalidations(Integer invalidations) {
        this.invalidations = invalidations;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }
}
