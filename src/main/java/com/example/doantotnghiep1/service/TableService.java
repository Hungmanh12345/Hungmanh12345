package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Table;

import java.util.List;

public interface TableService {
    Table add(Table table);

    Table update(String id, Table table);

    String deleteTable(String id);

    List<Table> getAll();

    Table getTableById(String id);

    Table getTableByCode(String numberTable);

}
