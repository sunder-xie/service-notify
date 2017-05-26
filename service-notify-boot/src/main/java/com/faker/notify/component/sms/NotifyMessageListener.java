package com.faker.notify.component.sms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.faker.notify.component.queue.ConsumerListener;
import com.faker.notify.component.sms.alibaba.AliSmsSender;
import com.faker.notify.model.RedisVerifyModel;
import com.faker.notify.model.SmsMessage;
import com.faker.notify.model.queue.Action;
import com.faker.notify.model.queue.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by faker on 17/3/30.
 */
@Component
public class NotifyMessageListener implements ConsumerListener {
    private static final Logger logger = LogManager.getLogger(NotifyMessageListener.class);


    @Autowired
    private AliSmsSender aliSmsSender;
//
//    @Resource(name = "redisTemplate")
//    private ValueOperations<String, String> ops;
//
    @Override
    public Action doConsume(Message xMessage) {

        JSON data = (JSON) xMessage.getData();
        SmsMessage smsMessage = JSONObject.toJavaObject(data, SmsMessage.class);
        Long smsId = Long.valueOf(xMessage.getKey());
        if (smsMessage.getVerifyCode()) {
            //插入redis
            RedisVerifyModel verifyModel = new RedisVerifyModel();

            verifyModel.setRetryLimit(smsMessage.getInvalidations());
            verifyModel.setVerifyCode(smsMessage.getParams()[0]);
            verifyModel.setTargetPhone(smsMessage.getTargetPhone());
            //使用spring redis
//            if (smsMessage.getKey()!=null){
//                ops.set(smsMessage.getTargetPhone()+smsMessage.getKey(), JSONObject.toJSONString(verifyModel), (long) smsMessage.getExpired(), TimeUnit.SECONDS);
//            }else {
//                ops.set(smsMessage.getTargetPhone(), JSONObject.toJSONString(verifyModel), (long) smsMessage.getExpired(), TimeUnit.SECONDS);
//
//            }
        }
        aliSmsSender.sendSms(smsMessage, smsId);
        return Action.Commit;
    }


}

