package com.example.demo.config;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnExpression("${swagger.enable:true}")
public class SwaggerConfig {
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.example.demo.controller";

    @Bean
    public Docket swaggerSpringMvcPlugin(){
        Contact contact = new Contact("my team", "", "");
        ApiInfo apiInfo = new ApiInfo(
                "服务名",
                "Generated By Swagger2",
                "1.0.0",
                "null",
                contact,
                "my Team",
                null,
                new ArrayList<>()
        );

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
//                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo)
                .useDefaultResponseMessages(true)
                .enable(true);
        return docket;
    }
}
