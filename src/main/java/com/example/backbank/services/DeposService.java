package com.example.backbank.services;

import com.example.backbank.dto.DeposDto;
import com.example.backbank.entity.Deposit;
import com.example.backbank.entity.Operation;
import com.example.backbank.entity.User;
import com.example.backbank.repositories.DepositRepository;
import com.example.backbank.repositories.OperationRepository;
import com.example.backbank.repositories.TarifRepository;
import com.example.backbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
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
    @Autowired
    private TarifRepository tarifRepository;

    public void createDepos(Principal user, DeposDto deposDto) {
        Deposit deposit = new Deposit();
        Optional<User> us = userRepository.findByUsername(user.getName());
        deposit.setUserId(us.get().getId());
        deposit.setWalletDepos(deposDto.getWalletDepos());
        deposit.setTarif(tarifRepository.getOne(deposDto.getTarif()));
        deposit.setDescription(deposDto.getDescription());
        deposit.setConfirm(false);
        try{
        depositRepository.save(deposit);
        Operation operation = new Operation(true, false, deposit.getId(), 2, deposDto.getDescription());
        operationRepository.save(operation);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Deposit> getAll() {
        return depositRepository.findAll();
    }
    public List<Deposit> getConfirm(User user){
        return depositRepository.findByUserIdAndConfirm(user.getId(),true);
    }

    public void update(long id,DeposDto deposDto){
        Deposit deposit = depositRepository.findById(id);;
        deposit.setWalletDepos(deposDto.getWalletDepos());
        deposit.setTarif(tarifRepository.getOne(deposDto.getTarif()));
        deposit.setDescription(deposDto.getDescription());
        deposit.setConfirm(false);
        depositRepository.save(deposit);
    }
}
