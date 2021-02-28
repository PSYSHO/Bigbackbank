package com.example.backbank.services;

import com.example.backbank.entity.CreditCards;
import com.example.backbank.entity.Operation;
import com.example.backbank.entity.User;
import com.example.backbank.repositories.CreditRepository;
import com.example.backbank.repositories.OperationRepository;
import com.example.backbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CreditService {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CreditRepository creditRepository;

    public List<CreditCards> getAll(){
        return creditRepository.findAll();
    }
    public void creatCredit(User user,CreditCards creditCards){
        CreditCards creditCards1 = new CreditCards();
        creditCards1.setConfirm(false);
        creditCards1.setDuration(creditCards.getDuration());
        creditCards1.setRate(creditCards.getRate());
        creditCards1.setLimitCard(creditCards.getLimitCard());
        creditCards1.setWallet(creditCards.getLimitCard());
        creditRepository.save(creditCards);
        Operation operation = new Operation(true, false, creditCards.getId(), 1, "");
        operationRepository.save(operation);
    }
    public List<CreditCards> getConfirm(User user){
        return creditRepository.findByUserIdAndConfirm(user.getId(),true);
    }
    public void save(CreditCards creditCards){
        creditRepository.save(creditCards);
    }

}
