package com.example.backbank.repositories;

import com.example.backbank.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<CreditCard,Long> {
    List<CreditCard> findByConfirm(boolean flag);
    List<CreditCard> findByUserIdAndConfirm(long id, boolean flag);
}
