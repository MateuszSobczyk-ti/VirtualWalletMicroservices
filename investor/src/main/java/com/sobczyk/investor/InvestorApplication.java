package com.sobczyk.investor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(
        basePackages = "com.sobczyk.clients"
)
public class InvestorApplication {
    public static void main(String[] args) {
        SpringApplication.run(InvestorApplication.class, args);
    }
}
