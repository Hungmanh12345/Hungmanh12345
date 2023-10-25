package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Authentication;

import java.util.List;
import java.util.Optional;

public interface AuthenticationService {
    Authentication save(Authentication authentication);

    Authentication update(String id, Authentication authentication);

    String deleteAuthen(String id);

    List<Authentication> getAuthen();


    Optional<Authentication> getAuthenById(String id);

    Authentication login(String userName);

    boolean checkLogin(String userName, String password);
}
