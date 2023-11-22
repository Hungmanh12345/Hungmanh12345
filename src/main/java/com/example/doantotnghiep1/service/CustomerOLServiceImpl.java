package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Book;
import com.example.doantotnghiep1.entity.CustomerOL;
import com.example.doantotnghiep1.repository.CustomerOLRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerOLServiceImpl implements CustomerOLService{
    private final CustomerOLRepository customerOLRepository;

    public CustomerOLServiceImpl(CustomerOLRepository customerOLRepository) {
        this.customerOLRepository = customerOLRepository;
    }
    @Override
    public void add(CustomerOL customerOL){
        customerOLRepository.save(customerOL);
    }
    @Override
    public CustomerOL getById(String id){
        return customerOLRepository.findById(id).orElse(null);
    }
    @Override
    public CustomerOL bookCustomer(Book book) {
        CustomerOL customerOL = new CustomerOL();
        customerOL
                .name(book.getBookName())
                .phone(book.getPhone());
        return  customerOLRepository.save(customerOL);
    }
}
