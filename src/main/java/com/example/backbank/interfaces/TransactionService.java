package com.example.backbank.interfaces;

import com.example.backbank.dto.TransactionDto;
import com.example.backbank.entity.Transaction;

import java.security.Principal;
import java.util.List;

public interface TransactionService {
    List<Transaction> getAll();

    List<Transaction> getAllByUser(Principal user);

    Transaction getByid(long id);

    void createTransaction(Principal user, TransactionDto transactionDto);

    void createTransactionCredit(Principal user, TransactionDto transactionDto, Long id);

    void createTransactionDeposit(Principal user, TransactionDto transactionDto, Long id);

    void updateTransaction(long id, TransactionDto transactionDto);

    void delTarif(long id);

}
