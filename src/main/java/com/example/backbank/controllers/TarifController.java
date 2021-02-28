package com.example.backbank.controllers;

import com.example.backbank.entity.Tarif;
import com.example.backbank.services.TarifService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bank/tarif")
public class TarifController {
    private TarifService tarifService;

    @GetMapping("")
    public List<Tarif> getTarif(){
        return tarifService.getAll();
    }
    @GetMapping("{/{Id}")
    public Tarif getById(@PathVariable long Id){
        return tarifService.getByid(Id);
    }
    @PostMapping("/add")
    public void createTarif(@RequestBody Tarif tarif){
       tarifService.createTarif(tarif);
    }
    @PutMapping
    public void updateTarif(@RequestBody Tarif tarif){
      tarifService.updateTarid(tarif);
    }
    @DeleteMapping("{/{Id}")
    public  void deleteTarif(@PathVariable("Id") long Id){
        tarifService.delTarif(Id);
    }
}
