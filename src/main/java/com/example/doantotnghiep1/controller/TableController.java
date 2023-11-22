package com.example.doantotnghiep1.controller;

import com.example.doantotnghiep1.entity.Customer;
import com.example.doantotnghiep1.entity.Table;
import com.example.doantotnghiep1.service.CustomerService;
import com.example.doantotnghiep1.service.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/tables")
public class TableController {
    private final TableService tableService;
    public final CustomerService customerService;

    public TableController(TableService tableService, CustomerService customerService) {
        this.tableService = tableService;
        this.customerService = customerService;
    }

    @GetMapping("/getTable")
    public String getBook( Model model){
        List<Table> tables = tableService.getAll();
        Collections.sort(tables, Comparator.comparingInt(table -> Integer.parseInt(table.getCode())));
        model.addAttribute("table", tables);
        return "table";
    }


    @PostMapping("/used/{id}")
    public String useTabled(@PathVariable String id) {
        Table table = tableService.getTableById(id);
        table.setAction("occupied");
        tableService.add(table);
        return "redirect:/tables/getTable";
    }

    @PostMapping("/deleted/{code}")
    public String deletedTabled(@PathVariable String code) {
        Table table = tableService.getTableByCode(code);
        table.setAction("empty");
        tableService.add(table);

        Customer customer = customerService.getByActionAndNumberTable("Chưa thanh toán",code);
        customer.setAction("Đã hủy");
        customerService.add(customer);
        return "redirect:/tables/getTable";
    }

    @PostMapping("/use/{id}")
    public String useTable(@PathVariable String id) {
        Table table = tableService.getTableById(id);
        table.setAction("occupied");
        tableService.add(table);
        return "redirect:/customer/add";
    }
    @PostMapping("/payCode/{code}")
    public String payForTable(@PathVariable("code") String numberTable) {
        Customer customer = customerService.getByActionAndNumberTable("Chưa thanh toán",numberTable);
        Table table = tableService.getTableByCode(numberTable);
        table.setAction("empty");
        tableService.add(table);
        return "redirect:/customer/payment/" + customer.getId();
    }
}
