package com.faker.controller;

import com.faker.api.SmsAPI;
import com.faker.model.SmsParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by faker on 17/5/24.
 */
@RestController
public class SmsController implements SmsAPI {

    @Value("${notify.name}")
    private String serviceName;


    @Override
    public String sendSms(@RequestBody SmsParam smsParam) {
        return "I am "+ serviceName+ ", phone: " + smsParam.getPhone();
    }
}
