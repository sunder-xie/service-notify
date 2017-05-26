package com.faker.notify.model;

import com.faker.notify.model.common.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;


/**
 * Created by faker on 17/3/17.
 */
@ApiModel(value = "模板实体")
public class TemplateQueryParam extends PageParam {

    private static final long serialVersionUID = 2170122176755629248L;

    @ApiParam(value = "模板序号")
//    @QueryParam("templateId")
    private Long templateId;
    @ApiParam(value = "模板代码")
//    @QueryParam("templateCode")
    private String templateCode;
    @ApiParam(value = "模板名称")
//    @QueryParam("templateName")
    private String templateName;
    @ApiParam(value = "模板格式")
//    @QueryParam("formatString")
    private String formatString;
    @ApiParam(value = "模板类型,模板类型,1-普通模板,2-语音模板")
//    @QueryParam("type")
    private Integer type;
    @ApiParam(value = "短信签名,1-房产销冠,2-销冠经纪,3-销冠管家,4-销冠金服,5-博达看板")
//    @QueryParam("signature")
    private Integer signature;
    @ApiParam(value = "供应商id,1-阿里大鱼,2-叮咚云,3-云之讯")
//    @QueryParam("provider")
    private Integer provider;
    @ApiParam(value = "模糊查询关键字,可以按内容,编码,名称")
//    @QueryParam("keyword")
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
