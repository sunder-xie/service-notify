package com.faker.notify.controller;

import com.faker.notify.api.TemplateAPI;
import com.faker.notify.dao.TemplateMapper;
import com.faker.notify.entity.Template;
import com.faker.notify.model.TemplateParam;
import com.faker.notify.model.TemplateQueryParam;
import com.faker.notify.model.TemplateResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Created by faker on 16/9/23.
 */
@RestController
public class TemplateController implements TemplateAPI{

    @Autowired
    private TemplateMapper templateMapper;

    @Override
    public Integer add(@RequestBody TemplateParam templateParam) {
        Template template = new Template();
        BeanUtils.copyProperties(templateParam, template);
        return templateMapper.insertSelective(template);
    }

    //todo : 了解query参数用mvc 怎么传以后再实现查询接口
    @Override
    public List<TemplateResultDTO> query(@RequestBody TemplateQueryParam templateDTO) {
        return null;
    }

    @Override
    public Integer update(@RequestBody TemplateParam templateDTO) {
        Template template = new Template();
        BeanUtils.copyProperties(templateDTO, template);
        Date date = Date.from(LocalDateTime.now().atZone(ZoneId.of(ZoneId.SHORT_IDS.get("CTT"))).toInstant());
        template.setUpdateTime(date);

        return templateMapper.updateByPrimaryKeySelective(template);
    }

    @Override
    public Integer delete(@ApiParam(name = "templateId", value = "templateId", required = true) @PathVariable Integer templateId) {
        return templateMapper.deleteByPrimaryKey(templateId);
    }
}
