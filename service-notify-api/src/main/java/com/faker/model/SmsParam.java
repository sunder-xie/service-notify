package com.faker.model;

import java.io.Serializable;

/**
 * Created by faker on 17/5/25.
 */
public class SmsParam implements Serializable{
    private static final long serialVersionUID = 264689266072417481L;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
