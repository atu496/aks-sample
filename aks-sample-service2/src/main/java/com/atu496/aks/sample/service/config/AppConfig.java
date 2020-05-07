package com.atu496.aks.sample.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.atu496.blank")
public class AppConfig {

@Bean
public RestTemplate resttemplate() {
    return new RestTemplate();
}
}
