package com.example.backbank.services;

import com.example.backbank.dto.TarifDto;
import com.example.backbank.dto.TransactionDto;
import com.example.backbank.entity.*;
import com.example.backbank.enums.TypeOperation;
import com.example.backbank.interfaces.TransactionService;
import com.example.backbank.repositories.CreditRepository;
import com.example.backbank.repositories.DepositRepository;
import com.example.backbank.repositories.TransactionRepository;
import com.example.backbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    private UserRepository userRepository;

    private DepositRepository depositRepository;

    private CreditRepository creditRepository;

    private CreditServiceImpl creditService;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, UserRepository userRepository, DepositRepository depositRepository, CreditRepository creditRepository, CreditServiceImpl creditService) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.depositRepository = depositRepository;
        this.creditRepository = creditRepository;
        this.creditService = creditService;
    }

    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getAllByUser(Principal user) {
        return transactionRepository.findByUser(userRepository.findByUsername(user.getName()).get().getId());
    }

    public Transaction getByid(long id) {
        return transactionRepository.findById(id);
    }

    public void createTransaction(Principal user, TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setConfirm(false);
        transaction.setType(transactionDto.getType());
        transaction.setWallet(transaction.getWallet());
        transaction.setDiscription(transactionDto.getWallet());
        transaction.setSumm(transactionDto.getSumm());
        transaction.setUser(userRepository.findByUsername(user.getName()).get());
        User us = userRepository.findByUsername(user.getName()).get();
        us.setWallet(us.getWallet() - transactionDto.getSumm());
        transaction.setWallet(transactionDto.getWallet());
        userRepository.save(us);
        transaction.setConfirm(true);
        transactionRepository.save(transaction);
    }

    public void refileWallet(Principal user, TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setConfirm(false);
        transaction.setType(transactionDto.getType());
        transaction.setWallet(transaction.getWallet());
        transaction.setDiscription(transactionDto.getWallet());
        transaction.setSumm(transaction.getSumm());
        transaction.setUser(userRepository.findByUsername(user.getName()).get());
        User us = userRepository.findByUsername(user.getName()).get();
        us.setWallet(us.getWallet() + transactionDto.getSumm());
        userRepository.save(us);
        transaction.setWallet(transactionDto.getWallet());
        transaction.setConfirm(true);
        transactionRepository.save(transaction);
    }

    public void createTransactionCredit(Principal user, TransactionDto transactionDto, Long id) {
        Transaction transaction = new Transaction();
        transaction.setConfirm(false);
        transaction.setType(transactionDto.getType());
        transaction.setWallet(transaction.getWallet());
        transaction.setDiscription(transactionDto.getWallet());
        transaction.setSumm(transaction.getSumm());
        transaction.setUser(userRepository.findByUsername(user.getName()).get());
        creditService.buy(user.getName(), id, transactionDto.getSumm());
        transaction.setConfirm(true);
        transactionRepository.save(transaction);
    }

    public void createTransactionDeposit(Principal user, TransactionDto transactionDto, Long id) {
        Transaction transaction = new Transaction();
        transaction.setConfirm(true);
        transaction.setSumm(transactionDto.getSumm());
        transaction.setType(transactionDto.getType());
        transaction.setWallet(transaction.getWallet());
        transaction.setDiscription(transactionDto.getWallet());
        transaction.setSumm(transaction.getSumm());
        transaction.setUser(userRepository.findByUsername(user.getName()).get());
        User us = userRepository.findByUsername(user.getName()).get();
        us.setWallet(us.getWallet() - transactionDto.getSumm());
        userRepository.save(us);
        transaction.setConfirm(true);
        Deposit deposit = depositRepository.findById(id).get();
        if (transactionDto.getType() == TypeOperation.Deposit)
            deposit.setWalletDepos(deposit.getWalletDepos() + transactionDto.getSumm());
        depositRepository.save(deposit);
        transaction.setWallet(transactionDto.getWallet());
        transactionRepository.save(transaction);
    }

    public void updateTransaction(long id, TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setConfirm(true);
        transaction.setType(transactionDto.getType());
        transaction.setWallet(transaction.getWallet());
        transaction.setDiscription(transactionDto.getWallet());
        transaction.setSumm(transaction.getSumm());
        transactionRepository.save(transaction);
    }

    public void delTarif(long id) {
        transactionRepository.deleteById(id);
    }
}
