package com.kennen.edgeservicegreeting.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

@Profile({"default", "insecure"})
@RestController
@RequestMapping(method = RequestMethod.GET, value = "/greet/{name}")
public class DefaultGreetingRestController {

    @RequestMapping
    public Map<String, String> hi(@PathVariable String name, HttpServletRequest request){
        System.out.println(request.getServerPort());
        return Collections.singletonMap("greeting", "Hello, " + name + "!" );
    }
}
