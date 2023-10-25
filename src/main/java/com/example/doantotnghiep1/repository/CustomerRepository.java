package com.example.doantotnghiep1.repository;

import com.example.doantotnghiep1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findByActionAndNumberTable(String action, String numberTable);

    Customer findByNumberTable(String numberTable);
}
