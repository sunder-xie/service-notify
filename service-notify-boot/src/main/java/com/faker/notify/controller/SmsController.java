package com.faker.notify.controller;

import com.faker.notify.api.SmsAPI;
import com.faker.notify.model.SmsParam;
import com.faker.notify.dao.SmsMapper;
import com.faker.notify.entity.Sms;
import com.faker.notify.model.SmsQueryParam;
import com.faker.notify.model.SmsResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by faker on 17/5/24.
 */
@RestController
public class SmsController implements SmsAPI {


    @Override
    public Long send(@RequestBody SmsParam smsParam) {
        return null;
    }

    @Override
    public List<SmsResultDTO> query(@RequestBody SmsQueryParam smsQueryParam) {
        return null;
    }
}
