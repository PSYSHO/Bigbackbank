package com.example.backbank.services;

import com.example.backbank.dto.DeposDto;
import com.example.backbank.entity.Deposit;
import com.example.backbank.entity.Operation;
import com.example.backbank.entity.User;
import com.example.backbank.enums.TypeOperation;
import com.example.backbank.interfaces.DeposService;
import com.example.backbank.repositories.DepositRepository;
import com.example.backbank.repositories.OperationRepository;
import com.example.backbank.repositories.TarifRepository;
import com.example.backbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DeposServiceImpl implements DeposService {
    @Autowired
    public DeposServiceImpl(UserRepository userRepository, DepositRepository depositRepository, OperationRepository operationRepository, TarifRepository tarifRepository) {
        this.userRepository = userRepository;
        this.depositRepository = depositRepository;
        this.operationRepository = operationRepository;
        this.tarifRepository = tarifRepository;
    }

    private UserRepository userRepository;
    private DepositRepository depositRepository;
    private OperationRepository operationRepository;
    private TarifRepository tarifRepository;

    public void createDepos(Principal user, DeposDto deposDto) {
        Deposit deposit = new Deposit();
        Optional<User> us = userRepository.findByUsername(user.getName());
        deposit.setUserId(us.get().getId());
        deposit.setWalletDepos(deposDto.getWalletDepos());
        deposit.setTarif(tarifRepository.getOne(deposDto.getTarif()));
        deposit.setDescription(deposDto.getDescription());
        deposit.setConfirm(false);
        deposit.setValidPeriod(LocalDate.now().plusMonths(deposDto.getDuration()));
        try {
            depositRepository.save(deposit);
            Operation operation = new Operation(true, false, deposit.getId(), TypeOperation.Deposit, deposDto.getDescription());
            operationRepository.save(operation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Deposit getById(long id) {
        return depositRepository.findById(id);
    }

    public List<Deposit> getAll() {
        return depositRepository.findAll();
    }

    public List<Deposit> getConfirm(String username) {
        User user = userRepository.findByUsername(username).get();
        return depositRepository.findByUserIdAndConfirm(user.getId(), true);
    }

    public void removeDeposit(String username, long id) {
        User user = userRepository.findByUsername(username).get();
        Deposit deposit = depositRepository.findById(id);
        user.setWallet(user.getWallet() + deposit.getWalletDepos());
        userRepository.save(user);
        depositRepository.delete(deposit);
    }

    public void update(long id, DeposDto deposDto) {
        Deposit deposit = depositRepository.findById(id);
        ;
        deposit.setWalletDepos(deposDto.getWalletDepos());
        deposit.setTarif(tarifRepository.getOne(deposDto.getTarif()));
        deposit.setDescription(deposDto.getDescription());
        deposit.setConfirm(false);
        depositRepository.save(deposit);
    }
}
