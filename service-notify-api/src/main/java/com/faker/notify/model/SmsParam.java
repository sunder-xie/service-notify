package com.faker.notify.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by faker on 17/3/17.
 */
@ApiModel(value = "短信实体")
public class SmsParam {
    @ApiModelProperty(value = "接收方手机号")
    private String targetPhone;
    @ApiModelProperty(value = "模板代码")
    private String templateCode;
    @ApiModelProperty(value = "模板参数数组")
    private String[] params;
    @ApiModelProperty(value = "扩展参数")
    private String extend;

    public String getTargetPhone() {
        return targetPhone;
    }

    public void setTargetPhone(String targetPhone) {
        this.targetPhone = targetPhone;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }
}
