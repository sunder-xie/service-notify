package com.faker.notify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.faker.notify.controller"))
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .apiInfo(ApiInfo());
    }

    private ApiInfo ApiInfo() {
        ApiInfo apiInfo = new ApiInfo("短信小号接口概览",//大标题
                "初稿1.0",//小标题
                "v1.0",//版本
                "https://github.com/caicai457614705/service-notify",
                "Faker",//作者
                "汪星人Spring Cloud计划",//链接显示文字
                "http://www.apache.org/licenses/LICENSE-2.0"//网站链接
        );

        return apiInfo;
    }

}
