package com.example.backbank.services;

import com.example.backbank.dto.TarifDto;
import com.example.backbank.entity.Tarif;
import com.example.backbank.repositories.TarifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TarifService {

    @Autowired
    private TarifRepository tarifRepository;


    public List<Tarif> getAll(){
        return   tarifRepository.findAll();
    }
    public Tarif getByid(long id){
      return   tarifRepository.findById(id);
    }

    public void createTarif(TarifDto tarifDto){
        Tarif tarif = new Tarif();
        tarif.setRate(tarifDto.getRate());
        tarif.setType(tarifDto.getType());
        tarifRepository.save(tarif);
    }
    public void updateTarid(long id,TarifDto tarifDto){
        Tarif tarif = tarifRepository.findById(id);
        tarif.setRate(tarifDto.getRate());
        tarif.setType(tarifDto.getType());
        tarifRepository.save(tarif);
    }
    public void delTarif(long id){
        tarifRepository.deleteById(id);
    }
}
