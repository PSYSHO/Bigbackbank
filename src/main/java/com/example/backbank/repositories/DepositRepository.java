package com.example.backbank.repositories;

import com.example.backbank.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositRepository extends JpaRepository<Deposit,Long> {
    List<Deposit> findByUserIdAndConfirm(long id,boolean flag);
    Deposit findById(long id);
    List<Deposit> findByTarif(long id);
}
