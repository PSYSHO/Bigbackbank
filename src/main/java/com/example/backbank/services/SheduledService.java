package com.example.backbank.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

@Service
public class SheduledService {
    private static final String Cron="0 0 6,19 * * *";//Вызов метода каждое утро и вечер
    @Scheduled(cron = Cron)
    public void validCredit(){}//метод проверяющий просрочку кредита
    @Scheduled(cron = Cron)
    public void validDeposit(){}//метод проверяющий просрочку депозита
    @Scheduled(cron = Cron)
    public void validPayment(){}//метод проверяющий просрочку оплаты кредита
}
