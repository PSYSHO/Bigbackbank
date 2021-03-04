package com.example.backbank.interfaces;

import com.example.backbank.entity.Operation;

import java.util.List;

public interface OperationService {
    void confirmDepos(long id);
    void confirmCredit(long id);
    List<Operation> getAll();
}
