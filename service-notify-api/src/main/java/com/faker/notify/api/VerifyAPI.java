package com.faker.notify.api;

import com.faker.notify.model.ValidateDTO;
import com.faker.notify.model.VerifyCodeParam;
import com.faker.notify.model.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by faker on 17/5/26.
 */

@Api("验证码模块")
@RequestMapping(value = "/verifycode")
public interface VerifyAPI {

    @ApiOperation(value = "发送验证码短信",notes = "")
    @RequestMapping(value = "/send",method = RequestMethod.POST)
    @ResponseBody
    public Long send(@RequestBody VerifyCodeParam verifyCodeDTO);

    @ApiOperation(value = "验证",notes = "")
    @RequestMapping(value = "/verify",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> verify(@RequestBody ValidateDTO validateDTO);
}
