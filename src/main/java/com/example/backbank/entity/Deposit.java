package com.example.backbank.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@ToString
@EqualsAndHashCode
@Entity
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float walletDepos;
    @OneToOne
    private Tarif tarif;
    private String Description;
    private long userId;
    private boolean confirm;

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
