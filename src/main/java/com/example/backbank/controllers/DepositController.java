package com.example.backbank.controllers;

import com.example.backbank.entity.Deposit;
import com.example.backbank.entity.Operation;
import com.example.backbank.entity.User;
import com.example.backbank.repositories.DepositRepository;
import com.example.backbank.repositories.OperationRepository;
import com.example.backbank.repositories.UserRepository;
import com.example.backbank.services.DeposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/bank/deposit")
public class DepositController {

    private DeposService deposService;

    public DepositController() {
    }

    @PutMapping()
    public void updateDeposit(@RequestBody Deposit deposit) {
        deposService.update(deposit);
    }

    @GetMapping()
    public List<Deposit> getConfirmDeposit(@AuthenticationPrincipal User user) {
        return deposService.getConfirm(user);
    }

    @PostMapping()
    public void createDeposit(@AuthenticationPrincipal User user, @RequestBody Deposit deposit) {
        deposService.createDepos(user, deposit);
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/all")
    public List<Deposit> getAllDeposit() {
        return deposService.getAll();
    }
}
