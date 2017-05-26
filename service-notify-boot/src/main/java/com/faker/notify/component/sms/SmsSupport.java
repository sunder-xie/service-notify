package com.faker.notify.component.sms;

import com.alibaba.fastjson.JSONObject;
import com.faker.notify.component.queue.KafkaSender;
import com.faker.notify.dao.SmsMapper;
import com.faker.notify.entity.Sms;
import com.faker.notify.model.SmsMessage;
import com.faker.notify.model.SmsParam;
import com.faker.notify.model.queue.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by faker on 17/3/30.
 */
@Service
public class SmsSupport {

    private static final Logger logger = LogManager.getLogger(SmsSupport.class);

    @Autowired
    protected SmsMapper smsMapper;

    @Autowired
    private KafkaSender kafkaSender;


    public Long insertSms(SmsParam smsParam) {
        Sms sms = new Sms();
        sms.setTargetPhone(smsParam.getTargetPhone());
        sms.setExtend(smsParam.getExtend());
        smsMapper.insertSelective(sms);
        return sms.getSmsId();
    }

    public Long sendMessage(Long smsId, SmsMessage smsMessage) {
        Message message = new Message();
        message.setData(smsMessage);
        message.setData("notify");
        message.setKey(smsId.toString());

        try {
            kafkaSender.send(message);
            logger.info("短信消息推送到消息队列成功:" + "[msgKey] :" + smsId + ";[msgBody]:" + JSONObject.toJSONString(message));
            return smsId;
        } catch (Exception e) {
            logger.error("短信消息推送到消息队列异常:" + "[msgKey] :" + smsId, e);
        }
        return null;
    }
}
