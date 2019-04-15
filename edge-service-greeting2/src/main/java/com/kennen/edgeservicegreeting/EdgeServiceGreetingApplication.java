package com.kennen.edgeservicegreeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EdgeServiceGreetingApplication {
    public static void main(String[] args) {
        SpringApplication.run(EdgeServiceGreetingApplication.class, args);
    }

}
