package com.faker.notify.controller;

import com.faker.notify.api.VerifyAPI;
import com.faker.notify.model.ValidateDTO;
import com.faker.notify.model.VerifyCodeParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * Created by faker on 16/9/23.
 */
@RestController
public class VerifyController implements VerifyAPI{

    @Override
    public Integer send(@RequestBody VerifyCodeParam verifyCodeDTO) {
        return null;
    }

    @Override
    public Integer verify(@RequestBody ValidateDTO validateDTO) {
        return null;
    }
}
