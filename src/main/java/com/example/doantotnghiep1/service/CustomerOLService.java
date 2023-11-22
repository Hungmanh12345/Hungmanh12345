package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Book;
import com.example.doantotnghiep1.entity.Customer;
import com.example.doantotnghiep1.entity.CustomerOL;
import com.example.doantotnghiep1.entity.Table;

public interface CustomerOLService {
    void add(CustomerOL customerOL);

    CustomerOL getById(String id);

    CustomerOL bookCustomer(Book book);
}
