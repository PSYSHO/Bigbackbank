package com.example.backbank.interfaces;

import com.example.backbank.dto.CreditDto;
import com.example.backbank.entity.CreditCard;
import com.example.backbank.entity.User;

import java.security.Principal;
import java.util.List;

public interface CreditService {
    void creatCredit(Principal user, CreditDto creditDto);
    List<CreditCard> getAll();
    void buy(Long id, Float Summ);
    List<CreditCard> getConfirm(User user);
    void update(long id, CreditDto creditDto);
}
