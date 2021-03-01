package com.example.backbank.controllers;

import com.example.backbank.entity.Operation;
import com.example.backbank.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/operation")
public class OperationController {
    @Autowired
    private OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @PostMapping("/credit/{Id}")
    public void confirmCredit(@PathVariable Long Id){
        operationService.ConfirmCredit(Id);
    }

    @PostMapping("/deposit/{Id}")
    public void confirmDepos(@PathVariable Long Id){
        operationService.ConfirmDeposit(Id);
    }
    @GetMapping()
    public List<Operation> getAll(){
        return operationService.getAll();
    }
}
