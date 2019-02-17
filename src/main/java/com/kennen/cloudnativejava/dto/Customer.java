package com.kennen.cloudnativejava.dto;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String email;

    public Customer() {
    }

    public Customer(String email) {
        this.email = email;
    }

    public Customer(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
