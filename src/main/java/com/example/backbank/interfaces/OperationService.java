package com.example.backbank.interfaces;

import com.example.backbank.entity.Operation;

import java.util.List;

public interface OperationService {
    void ConfirmCredit(Long id);
    void ConfirmDeposit(Long id);
    List<Operation> getAll();
}
