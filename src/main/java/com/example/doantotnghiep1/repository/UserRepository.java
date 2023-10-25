package com.example.doantotnghiep1.repository;

import com.example.doantotnghiep1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
