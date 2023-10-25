package com.example.doantotnghiep1.repository;

import com.example.doantotnghiep1.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, String> {
    Table findByCode(String code);
}
