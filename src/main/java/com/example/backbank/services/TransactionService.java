package com.example.backbank.services;

import com.example.backbank.dto.TarifDto;
import com.example.backbank.dto.TransactionDto;
import com.example.backbank.entity.Tarif;
import com.example.backbank.entity.Transaction;
import com.example.backbank.repositories.TransactionRepository;
import com.example.backbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;

    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    public Transaction getByid(long id) {
        return transactionRepository.findById(id);
    }

    public void createTransaction(long id, TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setConfirm(false);
        transaction.setType(transactionDto.getType());
        transaction.setWallet(transaction.getWallet());
        transaction.setDiscription(transactionDto.getWallet());
        transaction.setSumm(transaction.getSumm());
        transaction.setUser(userRepository.findById(id).get());
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
