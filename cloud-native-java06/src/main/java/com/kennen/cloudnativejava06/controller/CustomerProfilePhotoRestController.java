package com.kennen.cloudnativejava06.controller;

import com.kennen.cloudnativejava06.repository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers/{id}/photo")
public class CustomerProfilePhotoRestController {

    @Autowired
    CustomerProfilePhotoRestController(@Value("C:\\images") String uploadDir, CustomerRespository customerRespository){

    }
}
