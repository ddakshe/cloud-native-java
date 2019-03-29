package com.kennen.cloudnativejava06.controller;

import com.kennen.cloudnativejava06.repository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("v1/customers")
public class CustomerRestController {

    @Autowired
    CustomerRespository customerRespository;

    @RequestMapping(method = RequestMethod.OPTIONS)
    ResponseEntity<?> options(){


        return ResponseEntity.ok().allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.HEAD, HttpMethod.OPTIONS, HttpMethod.PUT, HttpMethod.DELETE).build();
    }


    @GetMapping
    ResponseEntity<String> get(){
        URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(3).toUri();

        return ResponseEntity.created(uri).body("String");
    }




}
