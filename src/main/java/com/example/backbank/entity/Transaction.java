package com.example.backbank.entity;

import com.example.backbank.enums.TypeOperation;
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
    private TypeOperation type;
    private String discription;
    private boolean confirm;

    public Transaction() {
    }

    public Transaction(long id, User user, String wallet, TypeOperation type, String discription, boolean confirm) {
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

    public TypeOperation getType() {
        return type;
    }

    public void setType(TypeOperation type) {
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

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }
}
