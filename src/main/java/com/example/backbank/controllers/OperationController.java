package com.example.backbank.controllers;

import com.example.backbank.entity.CreditCard;
import com.example.backbank.entity.Deposit;
import com.example.backbank.entity.Operation;
import com.example.backbank.services.CreditServiceImpl;
import com.example.backbank.services.DeposServiceImpl;
import com.example.backbank.services.OperationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bank/operation")
public class OperationController {
    @Autowired
    private OperationServiceImpl operationServiceImp;
    @Autowired
    private CreditServiceImpl creditService;
    @Autowired
    DeposServiceImpl deposService;

    public OperationController(OperationServiceImpl operationServiceImp, CreditServiceImpl creditService) {
        this.operationServiceImp = operationServiceImp;
        this.creditService = creditService;
    }

    @PostMapping("/credit/{Id}")
    public void confirmCredit(@PathVariable long Id){
        operationServiceImp.confirmCredit(Id);
    }

    @PostMapping("/deposit/{Id}")
    public void confirmDepos(@PathVariable long Id){
        operationServiceImp.confirmDepos(Id);
    }
    @GetMapping("")
    public List<Operation> getAll(){
        return operationServiceImp.getAll();
    }
    @GetMapping("/credit")
    public List<Operation> getAllCredit(){
        return operationServiceImp.getAllCreditOperation();
    }
    @GetMapping("/depos")
    public List<Operation> getAllDepos(){
        return operationServiceImp.getAllDeposOperation();
    }


    @GetMapping("/credit/{id}")
    public CreditCard getCredit(@PathVariable long id)
    {
        CreditCard creditCard = creditService.getCredit(id);
        return creditCard;
    }
    @GetMapping("/deposit/{id}")
    public Deposit getDepos(@PathVariable long id)
    {
        Deposit deposit = deposService.getById(id);
        return deposit;
    }
}
