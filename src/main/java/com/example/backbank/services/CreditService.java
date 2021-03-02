package com.example.backbank.services;

import com.example.backbank.dto.CreditDto;
import com.example.backbank.entity.CreditCard;
import com.example.backbank.entity.Operation;
import com.example.backbank.entity.Payment;
import com.example.backbank.entity.User;
import com.example.backbank.repositories.CreditRepository;
import com.example.backbank.repositories.OperationRepository;
import com.example.backbank.repositories.PaymentRepository;
import com.example.backbank.repositories.UserRepository;
import com.sun.xml.bind.v2.runtime.reflect.Lister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class CreditService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    public List<CreditCard> getAll() {
        return creditRepository.findAll();
    }

    public void creatCredit(Principal user, CreditDto creditDto) {
        User user1 = userRepository.findByUsername(user.getName()).get();
        CreditCard creditCard = createData(user1, creditDto);
        Operation operation = new Operation(true, false, creditCard.getId(), 1, "");
        operationRepository.save(operation);
    }

    public void buy(Long id, Float Summ) {
        CreditCard creditCard = creditRepository.findById(id).get();
        if (creditCard.getWallet() > Summ) {
            float loan = Summ / creditCard.getDuration();
            List<Payment> payments = new LinkedList<>();
            for (int i = 0; i < creditCard.getDuration(); i++)payments.add(new Payment(loan,new Date()));
            creditCard.setPayments(payments);
            creditCard.setWallet(creditCard.getWallet()-Summ);
            creditRepository.save(creditCard);
        }else;

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

    public void update(long id, CreditDto creditDto) {
        CreditCard creditCard = creditRepository.findById(id);
        creditCard.setConfirm(false);
        creditCard.setDuration(creditDto.getDuration());
        creditCard.setRate(creditDto.getRate());
        creditCard.setLimitCard(creditDto.getLimitCard());
        creditCard.setWallet(creditDto.getLimitCard());
        creditRepository.save(creditCard);
    }

}
