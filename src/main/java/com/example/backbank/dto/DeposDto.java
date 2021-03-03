package com.example.backbank.dto;

import com.example.backbank.entity.Tarif;

import javax.persistence.OneToOne;

public class DeposDto {
    private Long walletDepos;
    private Long tarif;
    private String Description;
    private Integer duration;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public long getWalletDepos() {
        return walletDepos;
    }

    public void setWalletDepos(Long walletDepos) {
        this.walletDepos = walletDepos;
    }

    public Long getTarif() {
        return tarif;
    }

    public void setTarif(Long tarif) {
        this.tarif = tarif;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
