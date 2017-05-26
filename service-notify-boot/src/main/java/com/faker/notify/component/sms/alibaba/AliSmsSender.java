package com.faker.notify.component.sms.alibaba;

import com.alibaba.fastjson.JSONObject;
import com.faker.notify.component.sms.AbstractSmsSender;
import com.faker.notify.entity.Template;
import com.faker.notify.model.SendResult;
import com.faker.notify.model.SmsParam;
import com.faker.notify.model.enums.SignatureEnum;
import com.faker.notify.model.enums.SmsStatusEnum;
import com.faker.notify.model.enums.TemplateTypeEnum;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.BizResult;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.request.AlibabaAliqinFcTtsNumSinglecallRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.taobao.api.response.AlibabaAliqinFcTtsNumSinglecallResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by faker on 17/3/17.
 */
@Component
public class AliSmsSender extends AbstractSmsSender {

    private static final Logger log = LogManager.getLogger(AliSmsSender.class);

    private static String url = "http://gw.api.taobao.com/router/rest";

    @Value("${alibaba_appKey}")
    private  String appKey;

    @Value("${alibaba_appSecret}")
    private  String appSecret;

    @Value("${alibaba_dialPhone}")
    private  String dialPhone;

    private TaobaoClient client;

    @PostConstruct
    private void init(){
        client = new DefaultTaobaoClient(url, appKey, appSecret);
    }

    @Override
    public SendResult doSendSms(SmsParam smsParam, Template template, Long smsId) {
        TemplateTypeEnum type = TemplateTypeEnum.valueOf(template.getType());
        switch (type) {
            case Normal:
                return this.sendTextSms(smsParam, template, smsId);
            case Radio:
                return this.sendRadioSms(smsParam, template, smsId);
            default:
                log.error("当前模板类型不支持");
                return null;
        }
    }

    private SendResult sendTextSms(SmsParam smsParam, Template template, Long smsId) {
        log.info("调用阿里大鱼文本短信接口");
        SendResult result = new SendResult();

        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setSmsType("normal");
        req.setSmsFreeSignName(SignatureEnum.getValueByCode(template.getSignature())
        );
        String[] params = smsParam.getParams();
        if (!StringUtils.isEmpty(template.getMapRule())) {
            JSONObject object = JSONObject.parseObject(template.getMapRule());
            List<String> paramsKey = new ArrayList<String>(object.keySet());
            if (paramsKey.size() == params.length) {
                for (int i = 0; i < params.length; i++) {
                    object.put(paramsKey.get(i), params[i]);
                }
            } else {
                result.setFailReason("参数个数与模板所需参数不一致");
                log.info("参数个数与模板所需参数不一致,smsId:{}",smsId);
            }
            req.setSmsParamString(object.toString());
        }

        req.setRecNum(smsParam.getTargetPhone());
        //查询获得三方模板编号
        req.setSmsTemplateCode(template.getProviderTemplateCode());
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            result.setFailReason("调用阿里大鱼文本短信接口发生异常");
            log.error("调用阿里大鱼文本短信接口发生异常", e);
        }
        if (rsp != null) {
            BizResult bizResult = rsp.getResult();
            if (bizResult != null) {
                result.setSerialNo(bizResult.getModel());
                result.setStatus(SmsStatusEnum.Sended);
                log.info("调用阿里大鱼文本短信接口成功,smsId:{},serailNo:{}", smsId, bizResult.getModel());

            } else {
                log.warn("调用阿里大鱼文本短信接口失败,smsId:{},failReason:{}", smsId, rsp.getSubMsg());
                result.setFailReason(rsp.getSubMsg());
            }
        } else {
            log.warn("阿里大鱼返回结果为空,smsId:{}",smsId);
            result.setFailReason("阿里大鱼返回结果为空");
        }

        return result;
    }

    private SendResult sendRadioSms(SmsParam smsParam, Template template, Long smsId) {
        log.info("调用阿里大鱼语音短信接口");
        SendResult result = new SendResult();


        AlibabaAliqinFcTtsNumSinglecallRequest req = new AlibabaAliqinFcTtsNumSinglecallRequest();
        req.setExtend(smsParam.getExtend());
        String[] params = smsParam.getParams();
        if (!StringUtils.isEmpty(template.getMapRule())) {
            JSONObject object = JSONObject.parseObject(template.getMapRule());
            List<String> paramsKey = new ArrayList<String>(object.keySet());
            if (paramsKey.size() == params.length) {
                for (int i = 0; i < params.length; i++) {
                    object.put(paramsKey.get(i), params[i]);
                }
            } else {
                result.setFailReason("参数个数与模板所需参数不一致");
                log.info("参数个数与模板所需参数不一致,smsId:{}",smsId);
            }
            req.setTtsParamString(object.toString());
        }
        req.setCalledNum(smsParam.getTargetPhone());
        req.setCalledShowNum(dialPhone);
        req.setTtsCode(template.getProviderTemplateCode());
        AlibabaAliqinFcTtsNumSinglecallResponse rsp = null;

        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            result.setFailReason("调用阿里大鱼语音短信接口发生异常");
            log.error("调用阿里大鱼语音短信接口发生异常", e);
        }
        if (rsp != null) {
            BizResult bizResult = rsp.getResult();
            if (bizResult != null) {
                result.setSerialNo(bizResult.getModel());
                result.setStatus(SmsStatusEnum.Sended);
                log.info("调用阿里大鱼语音短信接口成功,smsId:{},serailNo:{}", smsId, bizResult.getModel());

            } else {
                log.warn("调用阿里大鱼语音短信接口失败,smsId:{},failReason:{}", smsId, rsp.getSubMsg());
                result.setFailReason(rsp.getSubMsg());

            }
        } else {
            log.warn("阿里大鱼语音短信接口返回结果为空,smsId:{}",smsId);
            result.setFailReason("阿里大鱼语音短信接口返回结果为空");
        }

        return result;
    }

}
