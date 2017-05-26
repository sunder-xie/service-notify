package com.faker.notify.controller;

import com.faker.notify.api.SmsAPI;
import com.faker.notify.component.sms.SmsSupport;
import com.faker.notify.dao.TemplateMapper;
import com.faker.notify.model.SmsMessage;
import com.faker.notify.model.SmsParam;
import com.faker.notify.dao.SmsMapper;
import com.faker.notify.entity.Sms;
import com.faker.notify.model.SmsQueryParam;
import com.faker.notify.model.SmsResultDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by faker on 17/5/24.
 */
@RestController
public class SmsController extends SmsSupport implements SmsAPI {


    private static final Logger log = LogManager.getLogger(SmsController.class);

    @Autowired
    private TemplateMapper templateMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long send(@RequestBody SmsParam smsParam) {
        SmsMessage message = new SmsMessage();
        BeanUtils.copyProperties(smsParam, message);
        Long smsId = this.insertSms(smsParam);
        return this.sendMessage(smsId, message);
    }

    //todo: 查询短信列表待实现
    @Override
    public List<SmsResultDTO> query(@RequestBody SmsQueryParam smsQueryParam) {
        return null;
    }
}
