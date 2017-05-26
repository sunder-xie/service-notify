package com.faker.notify.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by faker on 17/3/17.
 */
@ApiModel(value = "验证码验证实体")
public class ValidateDTO {
    @ApiModelProperty(value = "验证码接收方手机号")
    private String targetPhone;
    @ApiModelProperty(value = "验证码")
    private String verifyCode;
    @ApiModelProperty(value = "是否验证成功就移除验证码,true-删除,false-不删除e")
    private boolean remove;
    @ApiModelProperty(value = "标识该次验证的key")
    private String key;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }
}
