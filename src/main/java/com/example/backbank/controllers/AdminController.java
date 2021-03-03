package com.example.backbank.controllers;

import com.example.backbank.entity.Role;
import com.example.backbank.entity.User;
import com.example.backbank.enums.RoleEnum;
import com.example.backbank.repositories.RoleRepository;
import com.example.backbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController()
@RequestMapping("/bank/admin")
public class AdminController {
    public AdminController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/users")
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @PutMapping("/oper")//todo Не успел изменить в конечной версии будер реворк
    public void getRoleOPER(@RequestBody User user) {
        Role role = roleRepository.findByName(RoleEnum.Operator).get();
        Set<Role> roleSet = new HashSet<>();
        boolean flag = true;
        for (Role role1 : user.getRoles()) {
            if (role1.getId() != 3) {
                roleSet.add(role1);
                flag = true;
            } else {
                flag = false;
            }
        }
        if (!flag) {
            user.setRoles(roleSet);
            userRepository.save(user);
            // System.out.println("Hello 1");
        } else {
            roleSet.add(role);
            user.setRoles(roleSet);
            userRepository.save(user);
            //  System.out.println("Hello ");
        }
    }

    @PostMapping("/adm")
    public void getRoleADM(@RequestBody User user) {
        Role role = roleRepository.findByName(RoleEnum.Admin).get();
        Set<Role> roleSet = new HashSet<>();
        boolean flag = true;
        for (Role role1 : user.getRoles()) {
            if (role1.getId() != 2) {
                roleSet.add(role1);
                flag = true;
            } else {
                flag = false;
            }
        }
        if (!flag) {
            user.setRoles(roleSet);
            userRepository.save(user);
            // System.out.println("Hello 1");
        } else {
            roleSet.add(role);
            user.setRoles(roleSet);
            userRepository.save(user);
            // System.out.println("Hello ");
        }
    }

    @PostMapping("/mode")
    public void getRoleMOD() {

    }
}
