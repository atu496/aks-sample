package com.atu496.aks.sample.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AksSampleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AksSampleAppApplication.class, args);
    }

}
