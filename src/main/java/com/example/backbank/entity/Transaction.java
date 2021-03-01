package com.example.backbank.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class Transaction {
    @Id
    private long id;
    @OneToOne
    private User user;
    private float summ;
    private String wallet;
    private String type;
    private String discription;
    private boolean confirm;
    private float rate;

    public Transaction() {
    }

    public Transaction(long id, User user, String wallet, String type, String discription, boolean confirm) {
        this.id = id;
        this.user = user;
        this.wallet = wallet;
        this.type = type;
        this.discription = discription;
        this.confirm = confirm;
    }

    public float getSumm() {
        return summ;
    }

    public void setSumm(float summ) {
        this.summ = summ;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean approved) {
        this.confirm = approved;
    }
}
