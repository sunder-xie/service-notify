package com.faker.notify.model;

import com.faker.notify.model.common.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by faker on 17/3/17.
 */
@ApiModel(value = "模板实体")
public class TemplateParam {
    @ApiModelProperty(value = "模板代码")
    private String templateCode;
    @ApiModelProperty(value = "模板名称")
    private String templateName;
    @ApiModelProperty(value = "模板格式")
    private String formatString;
    @ApiModelProperty(value = "模板类型")
    private Integer type;
    @ApiModelProperty(value = "三方模板id")
    private Integer templateKid;
    @ApiModelProperty(value = "短信签名")
    private Integer signature;
    @ApiModelProperty(value = "供应商id")
    private Integer provider;

    public Integer getSignature() {
        return signature;
    }

    public void setSignature(Integer signature) {
        this.signature = signature;
    }

    public Integer getProvider() {
        return provider;
    }

    public void setProvider(Integer provider) {
        this.provider = provider;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getFormatString() {
        return formatString;
    }

    public void setFormatString(String formatString) {
        this.formatString = formatString;
    }

    public Integer getTemplateKid() {
        return templateKid;
    }

    public void setTemplateKid(Integer templateKid) {
        this.templateKid = templateKid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
