package com.example.doantotnghiep1;

import com.example.doantotnghiep1.entity.Authentication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DoAnTotNghiep1Application {

    public static void main(String[] args) {
        SpringApplication.run(DoAnTotNghiep1Application.class, args);
    }

    @Bean(name = "Authen")
    public Authentication setAuthen(){
        Authentication authentication = new Authentication();
        authentication.userName("admin");
        authentication.password("admin123456");
        return  authentication;
    }
}
