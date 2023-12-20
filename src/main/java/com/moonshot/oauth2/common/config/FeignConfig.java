package com.moonshot.oauth2.common.config;

import com.moonshot.oauth2.Oauth2Application;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackageClasses = Oauth2Application.class)
public class FeignConfig {
}
