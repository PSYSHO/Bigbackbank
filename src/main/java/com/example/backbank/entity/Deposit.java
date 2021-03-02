package com.example.backbank.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@EqualsAndHashCode
@Entity
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Float walletDepos;
    @OneToOne
    private Tarif tarif;
    private String Description;
    private Long userId;
    private boolean confirm;
    private Date workingPeriod;

    public Deposit() {

    }

    public Deposit(Date workingPeriod) {
        this.workingPeriod = workingPeriod;
    }

    public void setWalletDepos(float wallet) {
        this.walletDepos = wallet;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getWalletDepos() {
        return walletDepos;
    }

    public Date getWorkingPeriod() {
        return workingPeriod;
    }

    public void setWorkingPeriod(Date workingPeriod) {
        this.workingPeriod = workingPeriod;
    }

    public Tarif getTarif() { return tarif; }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
