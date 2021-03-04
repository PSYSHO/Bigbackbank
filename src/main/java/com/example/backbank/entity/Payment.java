package com.example.backbank.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@ToString
@EqualsAndHashCode
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Float summ;
    private LocalDate date;

    public Payment(float summ,  LocalDate date) {
        this.summ = summ;
        this.date = date;
    }

    public Payment() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getSumm() {
        return summ;
    }

    public void setSumm(float summ) {
        this.summ = summ;
    }

    public  LocalDate getDate() {
        return date;
    }

    public void setDate( LocalDate date) {
        this.date = date;
    }
}
