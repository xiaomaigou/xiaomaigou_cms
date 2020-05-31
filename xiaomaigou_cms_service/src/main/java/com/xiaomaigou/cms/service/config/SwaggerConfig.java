package com.xiaomaigou.cms.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/31 23:09
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .description("小麦购商城CMS接口")
                .contact(new Contact("XiaoMaiGou.COM", "http://www.xiaomaigou.com", "xiaomaiyun@gmail.com"))
                .version("v1.2.3").title("小麦购商城CMS").license("Apache2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").build();
    }
}