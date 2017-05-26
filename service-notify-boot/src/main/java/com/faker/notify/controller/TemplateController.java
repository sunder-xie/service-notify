package com.faker.notify.controller;

import com.faker.notify.api.TemplateAPI;
import com.faker.notify.model.TemplateParam;
import com.faker.notify.model.TemplateResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by faker on 16/9/23.
 */
@RestController
public class TemplateController implements TemplateAPI{


    @Override
    public String add(@RequestBody TemplateParam templateDTO) {
        return null;
    }

    @Override
    public List<TemplateResultDTO> query(@RequestBody TemplateParam templateDTO) {
        return null;
    }

    @Override
    public Integer update(@RequestBody TemplateParam templateDTO) {
        return null;
    }

    @Override
    public Integer delete(@ApiParam(name = "templateId", value = "templateId", required = true) @PathVariable Long templateId) {
        return null;
    }
}
