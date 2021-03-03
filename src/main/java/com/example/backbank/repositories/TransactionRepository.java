package com.example.backbank.repositories;

import com.example.backbank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction > findByUser(long id);
    Transaction findById(long id);
}
