package com.example.backbank.controllers;

import com.example.backbank.entity.Tarif;
import com.example.backbank.enums.TypeProduct;
import com.example.backbank.repositories.TarifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bank/tarif")
public class TarifController {
    @Autowired
    private TarifRepository tarifRepository;

    @GetMapping("")
    public List<Tarif> getTarif(){
        return tarifRepository.findAll();
    }
    @GetMapping("{/{Id}")
    public Tarif getById(@PathVariable long Id){
        return tarifRepository.findById(Id);
    }
    @PostMapping("/add")
    public void createTarif(@RequestBody Tarif tarif){
        Tarif tarif1 = new Tarif();
        tarif1.setRate(tarif.getRate());
        tarif1.setType(tarif.getType());
        tarifRepository.save(tarif1);
    }
    @PutMapping
    public void updateTarif(@RequestBody Tarif tarif){
        Tarif tarif1 = tarifRepository.findById(tarif.getId());
        tarif1.setRate(tarif.getRate());
        tarif1.setType(tarif.getType());
        tarifRepository.save(tarif1);
    }
    @DeleteMapping("{/{Id}")
    public  void deleteTarif(@PathVariable("Id") long Id){
        tarifRepository.deleteById(Id);
    }
}
