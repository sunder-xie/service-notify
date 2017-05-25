package com.faker.api;

import com.faker.model.SmsParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by faker on 17/5/25.
 */
public interface SmsAPI {
    @RequestMapping(value = "/hi",method = RequestMethod.POST)
    public String sendSms(@RequestBody SmsParam smsParam);
}
