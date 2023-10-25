package com.example.doantotnghiep1.controller;

import com.example.doantotnghiep1.entity.Authentication;
import com.example.doantotnghiep1.service.AuthenticationService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public String add(@RequestBody Authentication authentication) {
        Authentication result = authenticationService.save(authentication);
        if(result != null){
            return "login";
        }
        return "register";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Authentication> update(@RequestBody Authentication authentication, @PathVariable String id) {
        Authentication result = authenticationService.update(id, authentication);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        String result = authenticationService.deleteAuthen(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Authentication>> getAuthen() {
        List<Authentication> result = authenticationService.getAuthen();
        return ResponseEntity.ok().body(result);
    }
}
