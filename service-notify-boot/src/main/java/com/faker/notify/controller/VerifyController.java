package com.faker.notify.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.faker.notify.api.VerifyAPI;
import com.faker.notify.component.sms.SmsSupport;
import com.faker.notify.model.RedisVerifyModel;
import com.faker.notify.model.SmsMessage;
import com.faker.notify.model.ValidateDTO;
import com.faker.notify.model.VerifyCodeParam;
import com.faker.notify.model.common.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by faker on 16/9/23.
 */
@RestController
public class VerifyController extends SmsSupport implements VerifyAPI {

        //todo: 集成redis后实现
//    @Resource(name = "redisTemplate")
//    private ValueOperations<String, String> ops;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long send(@RequestBody VerifyCodeParam verifyCodeParam) {

        //生成验证码
        Double max = Math.pow(10, verifyCodeParam.getMaxLength());
        Double min = Math.pow(10, verifyCodeParam.getMinLength() - 1);
        String verifyCode = String.valueOf((int) (Math.random() * (max - min - 1) + min));
        String[] realParams = {verifyCode};
        String[] params = verifyCodeParam.getParams();
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                realParams[i + 1] = params[i];
            }
        } else {
            if (null == verifyCodeParam.getTemplateCode()) {
                verifyCodeParam.setTemplateCode("FC_YZM");
            }
        }

        verifyCodeParam.setParams(realParams);
        SmsMessage message = new SmsMessage();
        message.setVerifyCode(true);
        BeanUtils.copyProperties(verifyCodeParam, message);

        Long smsId = this.insertSms(verifyCodeParam);

        return this.sendMessage(smsId, message);
    }

    @Override
    public Result<Boolean> verify(@RequestBody ValidateDTO validateDTO) {
        Object redisItem = null;
        //确认redis里面存储的key
        String key = validateDTO.getTargetPhone();
        if (validateDTO.getKey() != null) {
            key = validateDTO.getTargetPhone() + validateDTO.getKey();
        }
        //查redis
//        redisItem = ops.get(key);

        if (redisItem != null) {
            JSON verifyJson = (JSON) JSON.parse(redisItem.toString());
            RedisVerifyModel verify = JSONObject.toJavaObject(verifyJson, RedisVerifyModel.class);
            //比较验证次数, 验证码等
            Integer retryLimit = verify.getRetryLimit();
            if (verify.getCurrentRetry() >= retryLimit) {
                return Result.createSuccess("该验证码验证次数超过最大限制", false);
            } else {
                if (verify.getTargetPhone().equals(validateDTO.getTargetPhone())) {
                    if (verify.getVerifyCode().equals(validateDTO.getVerifyCode())) {
                        if (validateDTO.isRemove()) {
//                            ops.getOperations().delete(key);
                        }
                        return Result.createSuccess("验证通过", true);
                    } else {
                        verify.setCurrentRetry(verify.getCurrentRetry() + 1);
//                        Long expire = ops.getOperations().getExpire(key);
//                        ops.set(key, JSONObject.toJSONString(verify), expire, TimeUnit.SECONDS);
                        return Result.createSuccess("输入验证码错误,请重试", false);
                    }
                } else {
                    return Result.createSuccess("验证失败,手机号不一致", false);
                }

            }
        } else {
            return Result.createSuccess("该验证码不存在或已经过期", false);
        }
    }
}
