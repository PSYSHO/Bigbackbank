package com.example.backbank.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class CreditCards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float rate;

    private float wallet;
    private long userId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Payment> payments;
    private int duration;
    private static final float PENI = 4000;
    private boolean confirm;
    private float limitCard;

    public CreditCards() {
    }

    public CreditCards(long id, float rate, float wallet, List<Payment> payments, int duration) {
        this.id = id;
        this.rate = rate;
        this.wallet = wallet;
        this.payments = payments;
        this.duration = duration;
    }

    public CreditCards(long id, float rate, float wallet, int duration) {
        this.id = id;
        this.rate = rate;
        this.wallet = wallet * (rate * (duration / 12));
        this.duration = duration;
        float summ = calcSumm(wallet, rate, duration);
        this.payments = new ArrayList<Payment>();
        Calendar c = new GregorianCalendar();
        c.setTime(new Date());
        payments.add(new Payment((summ / duration), new Date()));
        for (int i = 1; i < duration; i++) {
            c.set(Calendar.MONTH, +1);
            payments.add(new Payment((summ / duration), c.getTime()));
        }
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
