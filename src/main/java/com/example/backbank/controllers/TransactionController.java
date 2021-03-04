package com.example.backbank.controllers;

import com.example.backbank.dto.TransactionDto;
import com.example.backbank.entity.Transaction;
import com.example.backbank.services.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bank/transaction")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionServiceImpl;

    public TransactionController(TransactionServiceImpl transactionServiceImpl) {
        this.transactionServiceImpl = transactionServiceImpl;
    }

    @GetMapping
    public List<Transaction> getAlL() {
        return transactionServiceImpl.getAll();
    }

    @GetMapping("/user")
    public List<Transaction> getAlLbyUser(Principal user) {
        return transactionServiceImpl.getAllByUser(user);
    }

    @GetMapping("/{Id}")
    public Transaction getById(@PathVariable long Id) {
        return transactionServiceImpl.getByid(Id);
    }

    @PostMapping()
    public void create(Principal user, @RequestBody TransactionDto transactionDto) {
        transactionServiceImpl.createTransaction(user, transactionDto);
    }
    @PostMapping("/refile")
    public void refile(Principal user, @RequestBody TransactionDto transactionDto) {
        transactionServiceImpl.refileWallet(user, transactionDto);
    }

    @PostMapping("/depos/{Id}")
    public void createDeposTrans(Principal user, @RequestBody TransactionDto transactionDto, @PathVariable Long Id) {
        transactionServiceImpl.createTransactionDeposit(user, transactionDto, Id);
    }

    @PostMapping("/credit/{Id}")
    public void createCreditTrans(Principal user, @RequestBody TransactionDto transactionDto, @PathVariable Long Id) {
        transactionServiceImpl.createTransactionCredit(user, transactionDto, Id);
    }

}
