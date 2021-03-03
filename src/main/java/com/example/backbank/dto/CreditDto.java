package com.example.backbank.dto;

public class CreditDto {
    private int currencyEnum;
    private Float rate;
    private Float limitCard;
    private Integer duration;

    public int getCurrencyEnum() {
        return currencyEnum;
    }

    public void setCurrencyEnum(int currencyEnum) {
        this.currencyEnum = currencyEnum;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public void setLimitCard(Float limitCard) {
        this.limitCard = limitCard;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
