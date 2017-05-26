package com.faker.notify.component.sms;

import com.faker.notify.model.SendResult;
import com.faker.notify.model.SmsParam;
import com.faker.notify.dao.SmsMapper;
import com.faker.notify.dao.TemplateMapper;
import com.faker.notify.entity.Sms;
import com.faker.notify.entity.Template;
import com.faker.notify.model.enums.SmsStatusEnum;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by faker on 17/3/17.
 */
public abstract class AbstractSmsSender {

    private static final Logger log = LogManager.getLogger(AbstractSmsSender.class);

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private SmsMapper smsMapper;

    public SmsStatusEnum sendSms(SmsParam smsParam, Long smsId) {
        SmsStatusEnum status = SmsStatusEnum.Failed;
        //查数据库
        Template template = new Template();
//        Template template = templateMapper.selectByTemplateCode(smsParam.getTemplateCode());
        if (template != null) {
            SendResult sendResult = doSendSms(smsParam, template,smsId);
            String content = this.assembleSmsContent(smsParam, template);

            Sms sms = new Sms();
            sms.setTemplateCode(template.getTemplateCode());
            sms.setSmsId(smsId);
            sms.setContent(content);
            sms.setTemplateId(template.getTemplateId());
            sms.setStatus(sendResult.getStatus().getCode());
            sms.setFailReason(sendResult.getFailReason());
            sms.setSerialNo(sendResult.getSerialNo());
            Date date = Date.from(LocalDateTime.now().atZone(ZoneId.of(ZoneId.SHORT_IDS.get("CTT"))).toInstant());
            sms.setUpdateTime(date);

            status = sendResult.getStatus();
            Integer result = this.smsMapper.updateByPrimaryKeySelective(sms);
            if (result>0){
                log.info("更新短信记录{}成功",smsId);
            }else {
                log.error("更新短信记录{}失败",smsId);
            }
        } else {
            log.error("未查询到相应模板");
        }
        return status;
    }

    protected String assembleSmsContent(SmsParam smsParam, Template template) {
        String content = "";
        if (template.getFormatString().contains("}") && template.getFormatString().contains("{")) {
            String[] params = smsParam.getParams();
            String[] s = template.getFormatString().replaceAll("\\}", "").split("\\{");
            StringBuilder base = new StringBuilder(s[0]);
            if (s.length == params.length + 1) {
                for (int i = 0; i < params.length; i++) {
                    base.append(params[i]).append(s[i + 1].substring(1));
                }
                log.info("短信内容为:" + base);
                content = base.toString();
            } else {
                log.error("参数个数与模板所需参数不一致");
            }
        } else {
            content = template.getFormatString();
        }

        return content;
    }


    public abstract SendResult doSendSms(SmsParam smsParam, Template template, Long smsId);


}
