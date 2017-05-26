package com.faker.notify.api;

import com.faker.notify.model.SmsParam;
import com.faker.notify.model.SmsQueryParam;
import com.faker.notify.model.SmsResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by faker on 17/5/25.
 */

@RequestMapping(value = "/sms")
@Api("短信模块")
public interface SmsAPI {
    @ApiOperation(value = "短信发送", notes = "")
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ResponseBody
    public Long send(@RequestBody SmsParam smsParam);


    @ApiOperation(value = "短信记录查询", notes = "")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public List<SmsResultDTO> query(@RequestBody SmsQueryParam smsQueryParam);
}
