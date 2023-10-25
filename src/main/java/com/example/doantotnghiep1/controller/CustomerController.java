package com.example.doantotnghiep1.controller;

import com.example.doantotnghiep1.entity.Customer;
import com.example.doantotnghiep1.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/add")
    public String add(Model model){
        Customer customer = new Customer();
        model.addAttribute("add", customer);
        return "addCustomer";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("add") Customer customer){
        customer
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .numberTable(customer.getNumberTable())
                .action("Chưa thanh toán");
        customerService.add(customer);
        return "redirect:/customer/getKH";
    }

    @GetMapping("/getKH")
    public String customers(Model model){
        model.addAttribute("customer", customerService.getKH());
        return "customer";
    }

    @PostMapping("/payed/{id}")
    public  String payed(@PathVariable String id, @RequestParam("total") int total){
        Customer customer = customerService.getById(id);
        customer.action("Đã thanh toán")
                .total(total);
        customerService.add(customer);
        return "redirect:/customer/getKH";
    }

    @GetMapping("/payment/{id}")
    public String showPaymentPage(@PathVariable("id") String id, Model model) {
        Customer customer = customerService.getById(id);
        model.addAttribute("pay", customer);
        return "pay";
    }

    @GetMapping("/detail/{id}")
    public String showDetailPage(@PathVariable("id") String id, Model model) {
        Customer customer = customerService.getById(id);
        model.addAttribute("detail", customer);
        return "detailsHD";
    }

    @GetMapping("/revenue")
    public String revenue(Model model, @RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate){
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.plusDays(1).atStartOfDay().minusSeconds(1);

        List<Customer> customerList = customerService.getKH()
                .stream()
                .filter(customer -> {
                    Date createdDate = customer.getCreatedDate();
                    Instant instant = createdDate.toInstant();
                    LocalDateTime createdDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
                    return !createdDateTime.isBefore(startDateTime) && !createdDateTime.isAfter(endDateTime);
                })
                .collect(Collectors.toList());
        int revenue = customerList
                .stream()
                .mapToInt(Customer::getTotal)
                .sum();
        model.addAttribute("revenue", revenue);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        return "RevenueStatistics";
    }
}
