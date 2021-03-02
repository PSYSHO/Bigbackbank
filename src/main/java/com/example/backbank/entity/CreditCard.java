package com.example.backbank.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Float rate;

    private Float wallet;
    private Long userId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Payment> payments;
    private Integer duration;
    private static final float PENI = 4000;
    private boolean confirm;
    private Float limitCard;
    private Date  workingPeriod;

    public CreditCard() {
        Float t;
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
        payments.add(new Payment((summ / duration), new Date()));
        for (int i = 1; i < duration; i++) {
            c.set(Calendar.MONTH, +1);
            payments.add(new Payment((summ / duration), c.getTime()));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Float getWallet() {
        return wallet;
    }

    public void setWallet(Float wallet) {
        this.wallet = wallet;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public static float getPENI() {
        return PENI;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public Float getLimitCard() {
        return limitCard;
    }

    public void setLimitCard(Float limitCard) {
        this.limitCard = limitCard;
    }

    public Date getWorkingPeriod() {
        return workingPeriod;
    }

    public void setWorkingPeriod(Date workingPeriod) {
        this.workingPeriod = workingPeriod;
    }

    public float calcSumm(float wallet, float rate, float duration) {
        float summ = wallet * (rate * (duration / 12));
        return summ;
    }

}
