package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.User;
import com.example.doantotnghiep1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user){
        return userRepository.save(user);
    }
    @Override
    public String deleteUser(String id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy")
        );
        userRepository.save(delete(user));
        return "đã xóa: " + id;
    }

    public User delete(User user) {
        user.setIsDeleted(1L);
        return user;
    }
    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }
    @Override
    public User getUserById(String id){
        return userRepository.findById(id).get();
    }
    @Override
    public User updateUser(User user, String id){
        User existUser = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy")
        );
        existUser
                .fullName(user.getFullName())
                .age(user.getAge())
                .sex(user.getSex())
                .phone(user.getPhone())
                .birth(user.getBirth())
                .address(user.getAddress());
        return userRepository.save(existUser);
    }
}
