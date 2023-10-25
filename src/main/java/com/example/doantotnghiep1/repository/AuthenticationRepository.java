package com.example.doantotnghiep1.repository;

import com.example.doantotnghiep1.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<Authentication , String> {
    Authentication findAuthenticationByFullName(String userName);

}
