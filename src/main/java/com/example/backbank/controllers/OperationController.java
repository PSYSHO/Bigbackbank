package com.example.backbank.controllers;

import com.example.backbank.entity.Operation;
import com.example.backbank.services.OperationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/operation")
public class OperationController {
    @Autowired
    private OperationServiceImpl operationServiceImp;

    public OperationController(OperationServiceImpl operationServiceImp) {
        this.operationServiceImp = operationServiceImp;
    }

    @PostMapping("/credit/{Id}")
    public void confirmCredit(@PathVariable Long Id){
        operationServiceImp.ConfirmCredit(Id);
    }

    @PostMapping("/deposit/{Id}")
    public void confirmDepos(@PathVariable Long Id){
        operationServiceImp.ConfirmDeposit(Id);
    }
    @GetMapping()
    public List<Operation> getAll(){
        return operationServiceImp.getAll();
    }
}
