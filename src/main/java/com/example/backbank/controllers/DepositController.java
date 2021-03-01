package com.example.backbank.controllers;

import com.example.backbank.dto.DeposDto;
import com.example.backbank.entity.Deposit;
import com.example.backbank.repositories.UserRepository;
import com.example.backbank.services.DeposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bank/deposit")
public class DepositController {
    @Autowired
    private DeposService deposService;
    @Autowired
    UserRepository userRepository;

    public DepositController() {
    }

    @PutMapping("/{Id}")
    public void updateDeposit(@PathVariable long Id, @RequestBody DeposDto deposDto) {
        deposService.update(Id, deposDto);
    }

    @GetMapping()
    public List<Deposit> getConfirmDeposit(Principal user) {
        return deposService.getConfirm(userRepository.findByUsername(user.getName()).get());

    }

    @PostMapping()
    public void createDeposit(Principal user, @RequestBody DeposDto deposDto) {
        deposService.createDepos(user, deposDto);
    }

    //@PreAuthorize("hasRole('Admin')")
    @GetMapping("/all")
    public List<Deposit> getAllDeposit() {
        return deposService.getAll();
    }
}
