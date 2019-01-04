package com.dh.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启用swagger2
 *
 * @author donghao
 * @date 2019/1/3
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${blog.swagger.title}")
    private String blogTitle;
    @Value("${blog.swagger.desc}")
    private String blogDesc;
    @Value("${blog.swagger.version}")
    private String blogVersion;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dh.blog"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(blogTitle)
                .description(blogDesc)
                .version(blogVersion)
                .build(); // 这部分信息其实可以自定义到配置文件中读取
    }
}