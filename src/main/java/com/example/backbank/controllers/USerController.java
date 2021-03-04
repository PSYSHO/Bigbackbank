package com.example.backbank.controllers;

import com.example.backbank.entity.User;
import com.example.backbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@CrossOrigin
@RestController
@RequestMapping("/bank")
public class USerController {
    public USerController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public User getUser(Principal user){
        User us =userRepository.findByUsername(user.getName()).get();
        return us;
    }
}
