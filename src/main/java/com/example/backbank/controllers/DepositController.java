package com.example.backbank.controllers;

import com.example.backbank.dto.DeposDto;
import com.example.backbank.entity.Deposit;
import com.example.backbank.repositories.UserRepository;
import com.example.backbank.services.DeposServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bank/deposit")
public class DepositController {
    @Autowired
    private DeposServiceImpl deposServiceImpl;
    @Autowired
    UserRepository userRepository;

    public DepositController() {
    }

    @PutMapping("/{Id}")
    public void updateDeposit(@PathVariable long Id, @RequestBody DeposDto deposDto) {
        deposServiceImpl.update(Id, deposDto);
    }

    @GetMapping()
    public List<Deposit> getConfirmDeposit(Principal user) {
        return deposServiceImpl.getConfirm(user.getName());

    }

    @PostMapping()
    public void createDeposit(Principal user, @RequestBody DeposDto deposDto) {
        deposServiceImpl.createDepos(user, deposDto);
    }

    //@PreAuthorize("hasRole('Admin')")
    @GetMapping("/all")
    public List<Deposit> getAllDeposit(Principal user) {
        return deposServiceImpl.getConfirm(user.getName());
    }
    @DeleteMapping("/{id}")
    public void removeDeposit(Principal user,@PathVariable long id){
        deposServiceImpl.removeDeposit(user.getName(),id);
    }
}
