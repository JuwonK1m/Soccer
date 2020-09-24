package com.kimjuwon.soccer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger {
    @Value("${project.version}")
    private String version;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName(this.version)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kimjuwon.soccer.controller"))
                .build()
                .securitySchemes(apiKey());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Soccer Project API")
                .description("API documentation for Soccer Project")
                .version(this.version)
                .build();
    }

    private List<ApiKey> apiKey() {
        List<ApiKey> list = new ArrayList<>();
        list.add(new ApiKey("JSON Web Token", "Authorization", "header"));
        return list;
    }
}
