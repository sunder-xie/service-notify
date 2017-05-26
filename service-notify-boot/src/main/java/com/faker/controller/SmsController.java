package com.faker.controller;

import com.faker.api.SmsAPI;
import com.faker.model.SmsParam;
import com.faker.notify.dao.SmsMapper;
import com.faker.notify.entity.Sms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Created by faker on 17/5/24.
 */
@RestController
public class SmsController implements SmsAPI {

    @Value("${notify.name}")
    private String serviceName;

    @Autowired
    private SmsMapper smsMapper;

    @Override
    public String sendSms(@RequestBody SmsParam smsParam) {
        return "I am "+ serviceName+ ", phone: " + smsParam.getPhone();
    }

    @RequestMapping("/sms/{smsId}")
    @ResponseBody
    public Sms getSms(@PathVariable Long smsId){
        return smsMapper.selectByPrimaryKey(smsId);
    }
}
