package com.example.backbank.controllers;

import com.example.backbank.dto.CreditDto;
import com.example.backbank.entity.CreditCard;
import com.example.backbank.entity.User;
import com.example.backbank.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/bank/credit")
public class CreditController {
    @Autowired
    private CreditService creditService;

    @PostMapping()
    public void createCredit(Principal user, @RequestBody CreditDto creditDto) {
        creditService.creatCredit(user, creditDto);
    }

    @PostMapping("/{Id}/{Summ}")
    public void buy(@PathVariable Long Id,@PathVariable Float Summ) {
        creditService.buy(Id,Summ);
    }

    @PutMapping("/{Id}")
    public void updateCredit(@PathVariable long Id,@RequestBody CreditDto creditDto) {
        creditService.update(Id,creditDto);
    }

    @GetMapping
    public List<CreditCard> getAllCredit(@AuthenticationPrincipal User user) {
        return creditService.getAll();
    }

    @GetMapping("/confirm")
    public List<CreditCard> getConfirmCredit(@AuthenticationPrincipal User user) {
        return creditService.getConfirm(user);
    }
    @DeleteMapping
    public void deleteCredit(){

    }

}
