package com.faker.notify.model.queue;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by faker on 17/5/26.
 */
public class Message implements Serializable{

    private static final long serialVersionUID = -5576908851765536597L;

    private String tag;
    private String key;
    private Object data;
    private Date sendTime;
    private int retryCount;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }
}
