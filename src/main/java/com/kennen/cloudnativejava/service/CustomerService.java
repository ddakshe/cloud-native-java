package com.kennen.cloudnativejava.service;

import com.kennen.cloudnativejava.dto.Customer;
import com.kennen.cloudnativejava.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerService {
//    private final JdbcTemplate jdbcTemplate;
//
//    public CustomerService(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public Collection<Customer> findAll(){
//        RowMapper<Customer> rowMapper = (rs, i) -> new Customer(rs.getLong("ID"), rs.getString("EMAIL"));
//        return this.jdbcTemplate.query("select * from CUSTOMER ", rowMapper);
//    }

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Collection<Customer> findAll(){
        return customerRepository.findAll();
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
