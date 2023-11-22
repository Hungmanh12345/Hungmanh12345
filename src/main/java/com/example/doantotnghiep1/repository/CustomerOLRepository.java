package com.example.doantotnghiep1.repository;

import com.example.doantotnghiep1.entity.Customer;
import com.example.doantotnghiep1.entity.CustomerOL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerOLRepository extends JpaRepository<CustomerOL, String> {

}
