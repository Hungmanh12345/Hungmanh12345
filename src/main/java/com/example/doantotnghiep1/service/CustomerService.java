package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer add(Customer customer);

    Customer update(String id, Customer customer);

    String deleteCustomer(String id);

    List<Customer> getKH();

    Customer getById(String id);

    Customer getByActionAndNumberTable(String action,String numberTable);

    Customer getByNumberTable(String numberTable);
}
