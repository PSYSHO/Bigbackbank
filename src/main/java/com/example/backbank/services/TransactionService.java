package com.example.backbank.services;

import com.example.backbank.dto.TarifDto;
import com.example.backbank.dto.TransactionDto;
import com.example.backbank.entity.*;
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
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    private CreditRepository creditRepository;

    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }
    public List<Transaction> getAllByUser(Principal user)
    {
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
        transaction.setSumm(transaction.getSumm());
        transaction.setUser(userRepository.findByUsername(user.getName()).get());
        User us = userRepository.findByUsername(user.getName()).get();
        us.setWallet(us.getWallet() - transactionDto.getSumm());
        userRepository.save(us);
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
        User us = userRepository.findByUsername(user.getName()).get();
        us.setWallet(us.getWallet() - transactionDto.getSumm());
        userRepository.save(us);
        CreditCard creditCard = creditRepository.findById(id).get();
        if (transactionDto.getType() == 1) creditCard.setWallet(creditCard.getWallet() - transactionDto.getSumm());
        else if (transactionDto.getType() == 2) creditCard.setWallet(creditCard.getWallet() + transaction.getSumm());
        creditRepository.save(creditCard);//todo логика чутка изменится
        transactionRepository.save(transaction);
    }

    public void createTransactionDeposit(Principal user, TransactionDto transactionDto, Long id) {
        Transaction transaction = new Transaction();
        transaction.setConfirm(false);
        transaction.setType(transactionDto.getType());
        transaction.setWallet(transaction.getWallet());
        transaction.setDiscription(transactionDto.getWallet());
        transaction.setSumm(transaction.getSumm());
        transaction.setUser(userRepository.findByUsername(user.getName()).get());
        User us = userRepository.findByUsername(user.getName()).get();
        us.setWallet(us.getWallet() - transactionDto.getSumm());
        userRepository.save(us);
        Deposit deposit = depositRepository.findById(id).get();
        if (transactionDto.getType() == 1) deposit.setWalletDepos(deposit.getWalletDepos() - transactionDto.getSumm());
        else if (transactionDto.getType() == 2) deposit.setWalletDepos(deposit.getWalletDepos() + transactionDto.getSumm());
        transactionRepository.save(transaction);
    }

    public void updateTransaction(long id, TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setConfirm(false);
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
