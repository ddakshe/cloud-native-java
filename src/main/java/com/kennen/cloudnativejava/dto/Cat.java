package com.kennen.cloudnativejava.dto;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Cat {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }
}