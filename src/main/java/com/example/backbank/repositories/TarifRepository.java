package com.example.backbank.repositories;

import com.example.backbank.entity.Tarif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifRepository extends JpaRepository<Tarif,Long> {
    Tarif findById(long id);
}
