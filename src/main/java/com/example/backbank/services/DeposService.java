package com.example.backbank.services;

import com.example.backbank.entity.Deposit;
import com.example.backbank.entity.Operation;
import com.example.backbank.entity.User;
import com.example.backbank.repositories.DepositRepository;
import com.example.backbank.repositories.OperationRepository;
import com.example.backbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DeposService {

    public DeposService(UserRepository userRepository, DepositRepository depositRepository, OperationRepository operationRepository) {
        this.userRepository = userRepository;
        this.depositRepository = depositRepository;
        this.operationRepository = operationRepository;
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    private OperationRepository operationRepository;

    public void createDepos(User user, Deposit deposit) {
        Deposit deposit1 = new Deposit();
        Optional<User> us = userRepository.findById(user.getId());
        deposit1.setUserId(us.get().getId());
        deposit1.setWalletDepos(deposit.getWalletDepos());
        deposit1.setTarif(deposit.getTarif());
        deposit1.setDescription(deposit.getDescription());
        deposit1.setConfirm(false);
        depositRepository.save(deposit1);
        Operation operation = new Operation(true, false, deposit.getId(), 2, deposit.getDescription());
        operationRepository.save(operation);
    }

    public List<Deposit> getAll() {
        return depositRepository.findAll();
    }
    public List<Deposit> getConfirm(User user){
        return depositRepository.findByUserIdAndConfirm(user.getId(),true);
    }

    public void update(Deposit deposit){
        depositRepository.save(deposit);
    }
}
