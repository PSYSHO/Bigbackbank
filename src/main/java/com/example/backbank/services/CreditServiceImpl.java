package com.example.backbank.services;

import com.example.backbank.dto.CreditDto;
import com.example.backbank.entity.CreditCard;
import com.example.backbank.entity.Operation;
import com.example.backbank.entity.Payment;
import com.example.backbank.entity.User;
import com.example.backbank.enums.CurrencyEnum;
import com.example.backbank.enums.TypeOperation;
import com.example.backbank.interfaces.CreditService;
import com.example.backbank.repositories.CreditRepository;
import com.example.backbank.repositories.OperationRepository;
import com.example.backbank.repositories.PaymentRepository;
import com.example.backbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {
    private UserRepository userRepository;
    private OperationRepository operationRepository;
    private CreditRepository creditRepository;
    private PaymentRepository paymentRepository;

    @Autowired
    public CreditServiceImpl(UserRepository userRepository, OperationRepository operationRepository, CreditRepository creditRepository, PaymentRepository paymentRepository) {
        this.userRepository = userRepository;
        this.operationRepository = operationRepository;
        this.creditRepository = creditRepository;
        this.paymentRepository = paymentRepository;
    }

    public List<CreditCard> getAll() {
        return creditRepository.findAll();
    }

    public List<CreditCard> getAllByUser(String username) {
        User user = userRepository.findByUsername(username).get();

        return creditRepository.findByUserIdAndConfirm(user.getId(), true);
    }

    public void creatCredit(Principal user, CreditDto creditDto) {
        User user1 = userRepository.findByUsername(user.getName()).get();
        CreditCard creditCard = createData(user1, creditDto);
        Operation operation = new Operation(true, false, creditCard.getId(), TypeOperation.Credit, "Ожидает подтверждения");
        operationRepository.save(operation);
    }

    public void buy(String username, long id, float summ) {
        User user = userRepository.findByUsername(username).get();
        CreditCard creditCard = creditRepository.findById(id);
        if (creditCard.getWallet() > summ) {
            if (creditCard.getCurrencyEnum().equals(CurrencyEnum.Dollar)) {
                user.setWallet(user.getWallet() + summ * 75);
            } else if (creditCard.getCurrencyEnum().equals(CurrencyEnum.Euro)) {
                user.setWallet(user.getWallet() + summ * 84);
            } else user.setWallet(user.getWallet() + summ);
            user.setWallet(user.getWallet() + summ);
            float loan = summ / creditCard.getDuration();
            List<Payment> payments = new LinkedList<>();
            for (int i = 0; i < creditCard.getDuration(); i++) payments.add(new Payment(loan, LocalDate.now()));
            creditCard.setPayments(payments);
            creditCard.setWallet(creditCard.getWallet() - summ);
            userRepository.save(user);
            creditRepository.save(creditCard);
        }

    }

    private CreditCard createData(User user, CreditDto creditDto) {
        CreditCard creditCard = new CreditCard();
        creditCard.setConfirm(false);
        creditCard.setUserId(user.getId());
        creditCard.setDuration(creditDto.getDuration());
        creditCard.setRate(creditDto.getRate());
        creditCard.setLimitCard(creditDto.getLimitCard());
        creditCard.setWallet(creditDto.getLimitCard());
        if (creditDto.getCurrencyEnum() == 1) creditCard.setCurrencyEnum(CurrencyEnum.Ruble);
        else if (creditDto.getCurrencyEnum() == 2) creditCard.setCurrencyEnum(CurrencyEnum.Dollar);
        else creditCard.setCurrencyEnum(CurrencyEnum.Euro);
        creditCard.setValidPeriod(LocalDate.now().minusMonths(creditDto.getDuration()));
        creditRepository.save(creditCard);
        return creditCard;
    }

    public CreditCard getCredit(long id) {
        CreditCard creditCard = creditRepository.findById(id);
        return creditCard;
    }

    public List<CreditCard> getConfirm(String user) {
        User user1 = userRepository.findByUsername(user).get();
        return creditRepository.findByUserIdAndConfirm(user1.getId(), true);
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
