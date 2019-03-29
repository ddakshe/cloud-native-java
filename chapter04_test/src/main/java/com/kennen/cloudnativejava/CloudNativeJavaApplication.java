package com.kennen.cloudnativejava;

import com.kennen.cloudnativejava.dto.Customer;
import com.kennen.cloudnativejava.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudNativeJavaApplication implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(CloudNativeJavaApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        customerService.save(new Customer("ddakshe@gmail.com"));
    }
}
