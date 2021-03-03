package com.example.backbank.controllers;

import com.example.backbank.entity.User;
import com.example.backbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/bank/product")
public class ProductUserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user")
    public User getUserInfo(Principal user){
        return userRepository.findByUsername(user.getName()).get();
    }
}
