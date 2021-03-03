package com.example.backbank.interfaces;

import com.example.backbank.dto.TarifDto;
import com.example.backbank.entity.Tarif;

import java.util.List;

public interface TarifService {
    List<Tarif> getAll();
    Tarif getByid(long id);
    void createTarif(TarifDto tarifDto);
    void updateTarif(long id, TarifDto tarifDto);
    void delTarif(long id);
}
