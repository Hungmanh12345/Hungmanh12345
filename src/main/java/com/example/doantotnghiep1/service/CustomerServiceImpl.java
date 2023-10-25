package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Customer;
import com.example.doantotnghiep1.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer add(Customer customer){
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getKH(){
        return customerRepository.findAll();
    }
    @Override
    public Customer getById(String id){
        return customerRepository.findById(id).get();
    }
    @Override
    public Customer getByActionAndNumberTable(String action, String numberTable){
        return customerRepository.findByActionAndNumberTable(action, numberTable);
    }

    @Override
    public Customer getByNumberTable(String numberTable){
        return customerRepository.findByNumberTable(numberTable);
    }
}
