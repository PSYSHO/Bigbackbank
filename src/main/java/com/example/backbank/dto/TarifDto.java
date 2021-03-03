package com.example.backbank.dto;

import com.example.backbank.enums.TarifEnum;

public class TarifDto {
    private int tarifEnum;
    private String name;
    float rate;

    public int getTarifEnum() {
        return tarifEnum;
    }

    public void setTarifEnum(int tarifEnum) {
        this.tarifEnum = tarifEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
