package com.kennen.edgeservicegreetingsclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Profile({"default", "insecure"})
@RestController
@RequestMapping("/api")
public class RestTemplateGreetingsClientApiGateway {

    private final RestTemplate restTemplate;

    @Autowired
    RestTemplateGreetingsClientApiGateway(@LoadBalanced RestTemplate restTemplate){
        /*@LoadBalanced 애노테이션이 붙은 RestTemplate 인스턴스에는 스프링 클라우드에 의해
        * 인터셉터가 설정된 클라이언트 로드밸런싱 기능이 적용된다.*/
        this.restTemplate = restTemplate;
    }

    @GetMapping("/resttemplate/{name}")
    Map<String, String> restTemplate(@PathVariable String name){
        ParameterizedTypeReference<Map<String, String>> type = new ParameterizedTypeReference<Map<String, String>>() {};
        ResponseEntity<Map<String, String>> responseEntity =
                this.restTemplate.exchange(
                        "http://greetings-service/greet/{name}",
                        HttpMethod.GET, null, type, name);
        return responseEntity.getBody();
    }
}