package com.example.backbank.repositories;

import com.example.backbank.entity.CreditCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<CreditCards,Long> {
    List<CreditCards> findByConfirm(boolean flag);
    List<CreditCards> findByUserIdAndConfirm(long id,boolean flag);
}
