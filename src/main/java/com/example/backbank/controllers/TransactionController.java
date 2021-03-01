package com.example.backbank.controllers;

import com.example.backbank.dto.TransactionDto;
import com.example.backbank.entity.Transaction;
import com.example.backbank.entity.User;
import com.example.backbank.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAlL() {
        return transactionService.getAll();
    }

    @GetMapping("/{Id}")
    public Transaction getById(@PathVariable long Id) {
        return transactionService.getByid(Id);
    }
    @PostMapping()
    public void create(@AuthenticationPrincipal User user,@RequestBody TransactionDto transactionDto){
        transactionService.createTransaction(user.getId(),transactionDto);
    }

}
