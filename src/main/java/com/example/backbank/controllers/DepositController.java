package com.example.backbank.controllers;

import com.example.backbank.entity.Deposit;
import com.example.backbank.entity.Operation;
import com.example.backbank.entity.User;
import com.example.backbank.repositories.DepositRepository;
import com.example.backbank.repositories.OperationRepository;
import com.example.backbank.repositories.UserRepository;
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
    public DepositController(DepositRepository depositRepository, UserRepository userRepository, OperationRepository operationRepository) {
        this.depositRepository = depositRepository;
        this.userRepository = userRepository;
        this.operationRepository = operationRepository;
    }

    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OperationRepository operationRepository;

    @PutMapping()
    public void updateDeposit(@RequestBody Deposit deposit){
        depositRepository.save(deposit);
    }
    @GetMapping()
    public List<Deposit> getConfirmDeposit(@AuthenticationPrincipal User user){
        List<Deposit> deposits = depositRepository.findAll();
        return deposits;
    }
    @PostMapping()
    public void createDeposit(Principal user, @RequestBody Deposit deposit){
        Deposit deposit1 = new Deposit();
        Optional<User> us =userRepository.findByUsername(user.getName());
        deposit1.setUserId(us.get().getId());
        deposit1.setWalletDepos(deposit.getWalletDepos());
        deposit1.setTarif(deposit.getTarif());
        deposit1.setDescription(deposit.getDescription());
        deposit1.setConfirm(false);
        depositRepository.save(deposit1);
        Operation operation = new Operation(true,false,deposit.getId(),2,deposit.getDescription());
        operationRepository.save(operation);
    }
    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/all")
    public List<Deposit> getAllDeposit(){
        return depositRepository.findAll();
    }
}
