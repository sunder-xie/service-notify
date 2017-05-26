package com.faker.notify.model;

import io.swagger.annotations.Api;

import java.util.Date;

/**
 * Created by faker on 17/3/17.
 */
@Api("后台模板展示实体")
public class TemplateResultDTO extends TemplateParam {
    private Long templateId;
    private Date createTime;
    private Date updateTime;
    private String extend;

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
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
}
