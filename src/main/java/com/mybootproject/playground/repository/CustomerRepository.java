package com.mybootproject.playground.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootproject.playground.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}