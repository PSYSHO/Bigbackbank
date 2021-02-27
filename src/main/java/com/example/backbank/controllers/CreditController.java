package com.example.backbank.controllers;

import com.example.backbank.entity.CreditCards;
import com.example.backbank.entity.User;
import com.example.backbank.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/bank/credit")
public class CreditController {
    public CreditController(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Autowired
    private CreditRepository creditRepository;

    @PostMapping()
    public void createCredit(Principal user,@RequestBody CreditCards creditCards){
        CreditCards creditCards1 = new CreditCards();
        creditCards1.setConfirm(false);
        creditCards1.setDuration(creditCards.getDuration());
        creditCards1.setRate(creditCards.getRate());
        creditCards1.setLimitCard(creditCards.getLimitCard());
        creditCards1.setWallet(creditCards.getLimitCard());
        creditRepository.save(creditCards);
    }
    @PutMapping()
    public void updateCredit(@RequestBody CreditCards creditCards){
        creditRepository.save(creditCards);
    }
    @GetMapping
    public List<CreditCards> getAllCredit(@AuthenticationPrincipal User user){
        return creditRepository.findAll();
    }
    @GetMapping("/confirm")
    public List<CreditCards> getConfirmCredit(@AuthenticationPrincipal User user){
       return creditRepository.findByUserIdAndConfirm(user.getId(),true);
    }

}
