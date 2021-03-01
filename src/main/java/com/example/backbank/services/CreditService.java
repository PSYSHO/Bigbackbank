package com.example.backbank.services;

import com.example.backbank.dto.CreditDto;
import com.example.backbank.entity.CreditCard;
import com.example.backbank.entity.Operation;
import com.example.backbank.entity.User;
import com.example.backbank.repositories.CreditRepository;
import com.example.backbank.repositories.OperationRepository;
import com.example.backbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class CreditService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CreditRepository creditRepository;

    public List<CreditCard> getAll() {
        return creditRepository.findAll();
    }

    public void creatCredit(Principal user, CreditDto creditDto) {
        User user1 = userRepository.findByUsername(user.getName()).get();
        CreditCard creditCard = createData(user1,creditDto);
        Operation operation = new Operation(true, false, creditCard.getId(), 1, "");
        operationRepository.save(operation);
    }

    private CreditCard createData(User user, CreditDto creditDto) {
        CreditCard creditCard = new CreditCard();
        creditCard.setConfirm(false);
        creditCard.setDuration(creditDto.getDuration());
        creditCard.setRate(creditDto.getRate());
        creditCard.setLimitCard(creditDto.getLimitCard());
        creditCard.setWallet(creditDto.getLimitCard());
        creditRepository.save(creditCard);
        return creditCard;
    }

    public List<CreditCard> getConfirm(User user) {
        return creditRepository.findByUserIdAndConfirm(user.getId(), true);
    }

    public void save(long id,CreditDto creditDto) {
        CreditCard creditCard = creditRepository.findById(id);
        creditCard.setConfirm(false);
        creditCard.setDuration(creditDto.getDuration());
        creditCard.setRate(creditDto.getRate());
        creditCard.setLimitCard(creditDto.getLimitCard());
        creditCard.setWallet(creditDto.getLimitCard());
        creditRepository.save(creditCard);
    }

}
