package com.example.backbank.controllers;

import com.example.backbank.dto.TarifDto;
import com.example.backbank.entity.Tarif;
import com.example.backbank.services.TarifServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bank/tarif")
public class TarifController {

    public TarifController(TarifServiceImpl tarifServiceImpl) {
        this.tarifServiceImpl = tarifServiceImpl;
    }

    private TarifServiceImpl tarifServiceImpl;

    @GetMapping("")
    public List<Tarif> getTarif() {
        return tarifServiceImpl.getAll();
    }

    @GetMapping("{/{Id}")
    public Tarif getById(@PathVariable long Id) {
        return tarifServiceImpl.getByid(Id);
    }

    @PostMapping("/add")
    public void createTarif(@RequestBody TarifDto tarif) {
        tarifServiceImpl.createTarif(tarif);

    }

    @PutMapping("/{Id}")
    public void updateTarif(@PathVariable long Id,@RequestBody TarifDto tarif) {
        tarifServiceImpl.updateTarif(Id,tarif);
    }

    @DeleteMapping("/{Id}")
    public void deleteTarif(@PathVariable("Id") long Id) {
        tarifServiceImpl.delTarif(Id);
    }
}
