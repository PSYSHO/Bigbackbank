package com.example.backbank.dto;

import com.example.backbank.entity.Payment;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

public class CreditDto {
    private Float rate;
    private Float limitCard;
    private int     duration;

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


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
