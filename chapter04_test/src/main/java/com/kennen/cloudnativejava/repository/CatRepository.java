package com.kennen.cloudnativejava.repository;


import com.kennen.cloudnativejava.dto.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CatRepository extends JpaRepository<Cat, Long> {
}