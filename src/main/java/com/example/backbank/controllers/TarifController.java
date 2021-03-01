package com.example.backbank.controllers;

import com.example.backbank.dto.TarifDto;
import com.example.backbank.entity.Tarif;
import com.example.backbank.services.TarifService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bank/tarif")
public class TarifController {

    public TarifController(TarifService tarifService) {
        this.tarifService = tarifService;
    }

    private TarifService tarifService;

    @GetMapping("")
    public List<Tarif> getTarif() {
        return tarifService.getAll();
    }

    @GetMapping("{/{Id}")
    public Tarif getById(@PathVariable long Id) {
        return tarifService.getByid(Id);
    }

    @PostMapping("/add")
    public void createTarif(@RequestBody TarifDto tarif) {
        tarifService.createTarif(tarif);
    }

    @PutMapping("/{Id}")
    public void updateTarif(@PathVariable long Id,@RequestBody TarifDto tarif) {
        tarifService.updateTarid(Id,tarif);
    }

    @DeleteMapping("{/{Id}")
    public void deleteTarif(@PathVariable("Id") long Id) {
        tarifService.delTarif(Id);
    }
}
