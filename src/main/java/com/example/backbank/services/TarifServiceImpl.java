package com.example.backbank.services;

import com.example.backbank.dto.TarifDto;
import com.example.backbank.entity.Tarif;
import com.example.backbank.enums.TarifEnum;
import com.example.backbank.interfaces.TarifService;
import com.example.backbank.payload.response.MessageResponse;
import com.example.backbank.repositories.DepositRepository;
import com.example.backbank.repositories.TarifRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
@Service
public class TarifServiceImpl implements TarifService {

    @Autowired
    private TarifRepository tarifRepository;
    @Autowired
    private DepositRepository depositRepository;


    public List<Tarif> getAll(){
        return   tarifRepository.findAll();
    }
    public Tarif getByid(long id){
      return   tarifRepository.findById(id);
    }

    public void createTarif(TarifDto tarifDto){
        Tarif tarif = new Tarif();
        tarif.setName(tarifDto.getName());
        tarif.setRate(tarifDto.getRate());
        if(tarifDto.getTarifEnum()==1)tarif.setType(TarifEnum.Refilable);else tarif.setType(TarifEnum.NonRefilable);
        tarifRepository.save(tarif);
    }
    public void updateTarif(long id, TarifDto tarifDto){
        Tarif tarif = tarifRepository.findById(id);
        tarif.setRate(tarifDto.getRate());
        tarif.setName(tarifDto.getName());
        if(tarifDto.getTarifEnum()==1)tarif.setType(TarifEnum.Refilable);else tarif.setType(TarifEnum.NonRefilable);
        tarifRepository.save(tarif);
    }
    public void delTarif(long id){
        try {
            tarifRepository.deleteById(id);
        }catch (Exception e){
            e.getMessage();
        }

    }
}
