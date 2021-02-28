package com.example.backbank.controllers;

import com.example.backbank.entity.CreditCards;
import com.example.backbank.entity.User;
import com.example.backbank.repositories.CreditRepository;
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
    private CreditService creditService;

    @PostMapping()
    public void createCredit(@AuthenticationPrincipal User user, @RequestBody CreditCards creditCards) {
        creditService.creatCredit(user, creditCards);
    }

    @PutMapping()
    public void updateCredit(@RequestBody CreditCards creditCards) {
        creditService.save(creditCards);
    }

    @GetMapping
    public List<CreditCards> getAllCredit(@AuthenticationPrincipal User user) {
        return creditService.getAll();
    }

    @GetMapping("/confirm")
    public List<CreditCards> getConfirmCredit(@AuthenticationPrincipal User user) {
        return creditService.getConfirm(user);
    }
    @DeleteMapping
    public void deleteCredit(){

    }

}
