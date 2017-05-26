package com.faker.notify.model.queue;

/**
 * Created by faker on 17/5/26.
 */
public enum Action {
    /**
     * 消费成功，继续消费下一个消息
     */
    Commit(1, "消费成功"),
    /**
     * 消费失败，重新消费
     */
    Resume(2, "消费失败");

    private Integer code;

    private String value;

    Action(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
