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
    private String wallet;
    private String Type;
    private String discription;
    private boolean approved;

    public Transaction() {
    }

    public Transaction(long id, User user, String wallet, String type, String discription, boolean approved) {
        this.id = id;
        this.user = user;
        this.wallet = wallet;
        Type = type;
        this.discription = discription;
        this.approved = approved;
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
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
