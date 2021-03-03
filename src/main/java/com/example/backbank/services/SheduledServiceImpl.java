package com.example.backbank.services;

import com.example.backbank.entity.CreditCard;
import com.example.backbank.entity.Deposit;
import com.example.backbank.interfaces.SheduleService;
import com.example.backbank.repositories.CreditRepository;
import com.example.backbank.repositories.DepositRepository;
import com.example.backbank.repositories.PaymentRepository;
import com.example.backbank.security.jwt.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SheduledServiceImpl implements SheduleService {

    public SheduledServiceImpl(CreditRepository creditRepository, DepositRepository depositRepository, PaymentRepository paymentRepository) {
        this.creditRepository = creditRepository;
        this.depositRepository = depositRepository;
        this.paymentRepository = paymentRepository;
    }

    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    private static final Logger logger = LoggerFactory.getLogger(SheduledServiceImpl.class);


    private static final String Cron = "0 0 6,19 * * *";//Вызов метода каждое утро и вечер

    @Scheduled(cron = Cron)
    public void validCredit() {
        int c = 0;
        List<CreditCard> cardList = creditRepository.findAll();
        for (CreditCard creditCard : cardList) {
            if (creditCard.getValidPeriod().isEqual(LocalDate.now())) {
                creditCard.setValidPeriod(LocalDate.now().plusMonths(creditCard.getDuration()));
                c++;
            }
        }
        creditRepository.saveAll(cardList);
        logger.info("Продленно кредитов =" + c);
    }//метод проверяющий просрочку кредита

    @Scheduled(cron = Cron)
    public void validDeposit() {
        int d = 0;
        List<Deposit> deposits = depositRepository.findAll();
        for (Deposit deposit : deposits) {
            if (deposit.getValidPeriod().isEqual(LocalDate.now())) {
                deposit.setValidPeriod(LocalDate.now().plusMonths(deposit.getValidPeriod().getMonthValue()));
                d++;
            }
        }
        logger.info("Продленно депозитов =" + d);
    }//метод проверяющий просрочку депозита

    @Scheduled(cron = Cron)
    public void validPayment() {

        System.out.println();
    }//метод проверяющий просрочку оплаты кредита
}
