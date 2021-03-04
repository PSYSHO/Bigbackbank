package com.example.backbank.controllers;

import com.example.backbank.dto.CreditDto;
import com.example.backbank.entity.CreditCard;
import com.example.backbank.entity.User;
import com.example.backbank.services.CreditServiceImpl;
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
    private CreditServiceImpl creditServiceImpl;

    @PostMapping()
    public void createCredit(Principal user, @RequestBody CreditDto creditDto) {
        creditServiceImpl.creatCredit(user, creditDto);
    }


    @PutMapping("/{Id}")
    public void updateCredit(@PathVariable long Id,@RequestBody CreditDto creditDto) {
        creditServiceImpl.update(Id,creditDto);
    }

    @GetMapping()
    public List<CreditCard> getAllCredit() {
        return creditServiceImpl.getAll();
    }

    @GetMapping("/all")
    public List<CreditCard> getAllCredit(Principal user) {
        return creditServiceImpl.getAll();
    }


    @GetMapping("/confirm")
    public List<CreditCard> getConfirmCredit(Principal user) {
        return creditServiceImpl.getConfirm(user.getName());
    }
    @DeleteMapping
    public void deleteCredit(){

    }

}
