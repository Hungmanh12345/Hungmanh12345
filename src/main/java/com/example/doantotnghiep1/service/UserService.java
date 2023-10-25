package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Table;
import com.example.doantotnghiep1.entity.User;

import java.util.List;

public interface UserService {
    User add(User user);

    String deleteUser(String id);

    List<User> getAll();


    User getUserById(String id);


    User updateUser(User user, String id);
}
