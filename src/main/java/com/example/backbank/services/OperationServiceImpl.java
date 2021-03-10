package com.example.backbank.services;

import com.example.backbank.entity.CreditCard;
import com.example.backbank.entity.Deposit;
import com.example.backbank.entity.Operation;
import com.example.backbank.enums.TypeOperation;
import com.example.backbank.interfaces.OperationService;
import com.example.backbank.repositories.CreditRepository;
import com.example.backbank.repositories.DepositRepository;
import com.example.backbank.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private DepositRepository depositRepository;

    public OperationServiceImpl(OperationRepository operationRepository, CreditRepository creditRepository, DepositRepository depositRepository) {
        this.operationRepository = operationRepository;
        this.creditRepository = creditRepository;
        this.depositRepository = depositRepository;
    }

    public void confirmDepos(long id) {
        Operation operation = operationRepository.findByProductid(id);
        Deposit deposit = depositRepository.findById(operation.getProductid());
        operation.setDescription("Операция подтверждена");
        operation.setApprovedOperator(true);
        deposit.setConfirm(true);
        depositRepository.save(deposit);
    }

    public void confirmCredit(long id) {
        Operation operation = operationRepository.findById(id);
        CreditCard creditCard = creditRepository.findById(operation.getProductid());
        operation.setDescription("Операция подтверждена");
        operation.setApprovedOperator(true);
        creditCard.setConfirm(true);
        creditRepository.save(creditCard);
    }
    public List<Operation> getAll(){
        return operationRepository.findAll();
    }
    public List<Operation> getAllDeposOperation(){
        return operationRepository.findByTypeAndAndApprovedOperator(TypeOperation.Deposit,false);
    }
    public List<Operation> getAllCreditOperation(){
        return operationRepository.findByTypeAndAndApprovedOperator(TypeOperation.Credit,false);
    }
}
