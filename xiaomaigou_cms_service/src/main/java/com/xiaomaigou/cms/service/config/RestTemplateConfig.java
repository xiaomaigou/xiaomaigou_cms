package com.xiaomaigou.cms.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate配置
 *
 * @author xiaomaiyun
 * @version 1.2.3
 * @date 2020/5/31 23:10
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {
        // 默认的RestTemplate，底层是走JDK的URLConnection方式。
//        return new RestTemplate();

        // 使用了httpclient,需要添加httpclient依赖
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory());

    }
}
