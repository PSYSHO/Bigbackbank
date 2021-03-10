package com.example.backbank.repositories;

import com.example.backbank.entity.Operation;
import com.example.backbank.enums.TypeOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
    Operation findByProductid(long id);
    Operation findById(long id);
    List<Operation> findByType(TypeOperation typeOperation);
    List<Operation> findByTypeAndAndApprovedOperator(TypeOperation typeOperation,boolean flag);
}
