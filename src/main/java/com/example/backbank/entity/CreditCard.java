package com.example.backbank.entity;

import com.example.backbank.enums.CurrencyEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float rate;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private CurrencyEnum currencyEnum;
    private float wallet;
    private long userId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Payment> payments;
    private int duration;
    private static final float PENI = 4000;
    private boolean confirm;
    private float limitCard;
    private LocalDate validPeriod;

    public static float getPENI() {
        return PENI;
    }

    public CreditCard() {
    }

    public CreditCard(long id, float rate, float wallet, List<Payment> payments, int duration) {
        this.id = id;
        this.rate = rate;
        this.wallet = wallet;
        this.payments = payments;
        this.duration = duration;
    }

    public CreditCard(long id, float rate, float wallet, int duration) {
        this.id = id;
        this.rate = rate;
        this.wallet = wallet * (rate * (duration / 12));
        this.duration = duration;
        float summ = calcSumm(wallet, rate, duration);
        this.payments = new ArrayList<Payment>();
        Calendar c = new GregorianCalendar();
        c.setTime(new Date());
        payments.add(new Payment((summ / duration), LocalDate.now()));
        for (int i = 1; i < duration; i++) {
            payments.add(new Payment((summ / duration),LocalDate.now().plusMonths(i)));
        }
    }

    public CurrencyEnum getCurrencyEnum() {
        return currencyEnum;
    }

    public void setCurrencyEnum(CurrencyEnum currencyEnum) {
        this.currencyEnum = currencyEnum;
    }

    public LocalDate getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(LocalDate validPeriod) {
        this.validPeriod = validPeriod;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getLimitCard() {
        return limitCard;
    }

    public void setLimitCard(float limitCard) {
        this.limitCard = limitCard;
    }


    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public float calcSumm(float wallet, float rate, float duration) {
        float summ = wallet * (rate * (duration / 12));
        return summ;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }


    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
