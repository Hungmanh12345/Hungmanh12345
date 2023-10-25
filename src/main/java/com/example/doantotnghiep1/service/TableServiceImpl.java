package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Table;
import com.example.doantotnghiep1.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService{
    private final TableRepository tableRepository;

    public TableServiceImpl(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }
    @Override
    public Table add(Table table){
        return tableRepository.save(table);
    }

    @Override
    public Table update(String id, Table table){
        Table existTable = tableRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy")
        );
        existTable
                .type(table.getType())
                .code(table.getCode())
                .numberSeats(table.getNumberSeats())
                .action(table.getAction());
        return existTable;
    }
    @Override
    public String deleteTable(String id){
        Table table = tableRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy")
        );
        tableRepository.save(delete(table));
        return "đã xóa: " + id;
    }

    public Table delete(Table table) {
        table.setIsDeleted(1L);
        return table;
    }
    @Override
    public List<Table> getAll(){
        return tableRepository.findAll();
    }

    @Override
    public Table getTableById(String id){
        return tableRepository.findById(id).get();
    }

    @Override
    public Table getTableByCode(String numberTable) {
        return tableRepository.findByCode(numberTable);
    }

}
