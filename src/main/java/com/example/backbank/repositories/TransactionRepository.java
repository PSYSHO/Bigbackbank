package com.example.backbank.repositories;

import com.example.backbank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    Transaction findById(long id);
}
