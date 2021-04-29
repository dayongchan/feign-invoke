package com.dayong.demo.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(FeignDemo2Application.class, args);
    }

}
