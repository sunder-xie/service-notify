package com.faker.notify.api;

import com.faker.notify.model.TemplateParam;
import com.faker.notify.model.TemplateQueryParam;
import com.faker.notify.model.TemplateResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by faker on 17/5/26.
 */
@Api("短信模板模块")
@RequestMapping(value = "/template")
public interface TemplateAPI {

    @ApiOperation(value = "添加模板", notes = "")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Integer add(@RequestBody TemplateParam templateDTO);

    @ApiOperation(value = "查询模板", notes = "")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public List<TemplateResultDTO> query(@RequestBody TemplateQueryParam templateQueryParam);

    @ApiOperation(value = "更新模板", notes = "")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public Integer update(@RequestBody TemplateParam templateDTO);

    @ApiOperation(value = "删除模板", notes = "")
    @RequestMapping(value = "/delete/{templateId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@ApiParam(name = "templateId", value = "templateId", required = true)
                          @PathVariable Integer templateId);
}
