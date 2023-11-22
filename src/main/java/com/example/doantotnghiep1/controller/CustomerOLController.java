package com.example.doantotnghiep1.controller;

import com.example.doantotnghiep1.service.CustomerOLService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customerOL")
public class CustomerOLController {
    private final CustomerOLService customerOLService;

    public CustomerOLController(CustomerOLService customerOLService) {
        this.customerOLService = customerOLService;
    }

//    @PostMapping("/addOL/{id}")
//    public String addOLByID(@PathVariable String id){
//        customerOLService.bookTable(id);
//
//    }
}
