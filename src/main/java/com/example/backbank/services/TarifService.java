package com.example.backbank.services;

import com.example.backbank.entity.Tarif;
import com.example.backbank.repositories.TarifRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TarifService {

    @Autowired
    private TarifRepository tarifRepository;


    public List<Tarif> getAll(){
        return   tarifRepository.findAll();
    }
    public Tarif getByid(long id){
      return   tarifRepository.findById(id);
    }

    public void createTarif(Tarif tarif){
        Tarif tarif1 = new Tarif();
        tarif1.setRate(tarif.getRate());
        tarif1.setType(tarif.getType());
        tarifRepository.save(tarif1);
    }
    public void updateTarid(Tarif tarif){
        Tarif tarif1 = tarifRepository.findById(tarif.getId());
        tarif1.setRate(tarif.getRate());
        tarif1.setType(tarif.getType());
        tarifRepository.save(tarif1);
    }
    public void delTarif(long id){
        tarifRepository.deleteById(id);
    }
}
