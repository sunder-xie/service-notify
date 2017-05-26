package com.faker.notify.entity;

import java.util.Date;

public class Template {
    private Integer templateId;

    private String templateCode;

    private String templateName;

    private String providerTemplateCode;

    private Byte signature;

    private String mapRule;

    private String formatString;

    private Byte provider;

    private Byte type;

    private String extend;

    private Date createTime;

    private Date updateTime;

    private Date sysTime;

    private Byte isDeleted;

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode == null ? null : templateCode.trim();
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public String getProviderTemplateCode() {
        return providerTemplateCode;
    }

    public void setProviderTemplateCode(String providerTemplateCode) {
        this.providerTemplateCode = providerTemplateCode == null ? null : providerTemplateCode.trim();
    }

    public Byte getSignature() {
        return signature;
    }

    public void setSignature(Byte signature) {
        this.signature = signature;
    }

    public String getMapRule() {
        return mapRule;
    }

    public void setMapRule(String mapRule) {
        this.mapRule = mapRule == null ? null : mapRule.trim();
    }

    public String getFormatString() {
        return formatString;
    }

    public void setFormatString(String formatString) {
        this.formatString = formatString == null ? null : formatString.trim();
    }

    public Byte getProvider() {
        return provider;
    }

    public void setProvider(Byte provider) {
        this.provider = provider;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getSysTime() {
        return sysTime;
    }

    public void setSysTime(Date sysTime) {
        this.sysTime = sysTime;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}