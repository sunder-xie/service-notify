package com.faker.notify.entity;

import java.util.Date;

public class SecretPhone {
    private Long secretId;

    private String secretPhone;

    private Long relationId;

    private String sourcePhone;

    private String targetPhone;

    private Byte needRecord;

    private Date expiredDate;

    private String remark;

    private Date createTime;

    private Date sysTime;

    private Byte isDeleted;

    public Long getSecretId() {
        return secretId;
    }

    public void setSecretId(Long secretId) {
        this.secretId = secretId;
    }

    public String getSecretPhone() {
        return secretPhone;
    }

    public void setSecretPhone(String secretPhone) {
        this.secretPhone = secretPhone == null ? null : secretPhone.trim();
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public String getSourcePhone() {
        return sourcePhone;
    }

    public void setSourcePhone(String sourcePhone) {
        this.sourcePhone = sourcePhone == null ? null : sourcePhone.trim();
    }

    public String getTargetPhone() {
        return targetPhone;
    }

    public void setTargetPhone(String targetPhone) {
        this.targetPhone = targetPhone == null ? null : targetPhone.trim();
    }

    public Byte getNeedRecord() {
        return needRecord;
    }

    public void setNeedRecord(Byte needRecord) {
        this.needRecord = needRecord;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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