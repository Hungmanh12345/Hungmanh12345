package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Authentication;
import com.example.doantotnghiep1.repository.AuthenticationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService{
    private final AuthenticationRepository authenticationRepository;

    public AuthenticationServiceImpl(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }
    @Override
    public Authentication save(Authentication authentication){
        return authenticationRepository.save(authentication);
    }
    @Override
    public Authentication update(String id, Authentication authentication){
        Authentication existAuthen = authenticationRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy")
        );
        existAuthen
                .fullName(authentication.getFullName())
                .userName(authentication.getUserName())
                .password(authentication.getPassword())
                .position(authentication.getPosition())
                .email(authentication.getEmail())
                .phone(authentication.getPhone());
        return authenticationRepository.save(existAuthen);
    }
    @Override
    public String deleteAuthen(String id){
        Authentication authentication = authenticationRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy")
        );
        authenticationRepository.save(delete(authentication));
        return "đã xóa: " + id;
    }

    public Authentication delete(Authentication authentication) {
        authentication.setIsDeleted(1L);
        return authentication;
    }

    @Override
    public List<Authentication> getAuthen(){
        return authenticationRepository.findAll();
    }
    @Override
    public Optional<Authentication> getAuthenById(String id){
        return authenticationRepository.findById(id);
    }
    @Override
    public Authentication login(String userName) {
        return authenticationRepository.findAuthenticationByFullName(userName);
    }
    @Override
    public boolean checkLogin(String userName, String password){
        Optional<Authentication> authentication = getAuthenById(userName);
        if (authentication.isPresent() && authentication.get().getPassword().equals(password)){
            return true;
        }else {
            return false;
        }
    }
}
