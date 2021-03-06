package com.kennen.html5client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Html5ClientApplication {

    private final LoadBalancerClient loadBalancerClient;

    public static void main(String[] args) {
        SpringApplication.run(Html5ClientApplication.class, args);
    }

    @Autowired
    Html5ClientApplication(LoadBalancerClient loadBalancerClient){
        this.loadBalancerClient = loadBalancerClient;
    }

    @GetMapping(value = "/greetings-client-uri", produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String, String> greetingsClientURI(){
        return Optional.ofNullable(this.loadBalancerClient.choose("greetings-client"))
                .map(si -> Collections.singletonMap("uri", si.getUri().toString()))
                .orElse(null);
    }

}
