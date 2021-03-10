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
        if(user.getRoles().contains(role)){
            roleSet = user.getRoles();
            roleSet.remove(role);
            user.setRoles(roleSet);
            userRepository.save(user);
        }else{
            roleSet = user.getRoles();
            roleSet.add(role);

            user.setRoles(roleSet);
            userRepository.save(user);
        }
    }

    @PutMapping("/adm")
    public void getRoleADM(@RequestBody User user) {
        Role role = roleRepository.findByName(RoleEnum.Admin).get();
        Set<Role> roleSet = new HashSet<>();
        if(user.getRoles().contains(role)){
            roleSet = user.getRoles();
            roleSet.remove(role);
            user.setRoles(roleSet);
            userRepository.save(user);
        }else{
            roleSet = user.getRoles();
            roleSet.add(role);

            user.setRoles(roleSet);
            userRepository.save(user);
        }
    }

    @PostMapping("/mode")
    public void getRoleMOD() {

    }
}
