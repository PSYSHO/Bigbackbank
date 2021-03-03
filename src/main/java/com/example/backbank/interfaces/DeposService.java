package com.example.backbank.interfaces;

import com.example.backbank.dto.DeposDto;
import com.example.backbank.entity.Deposit;
import com.example.backbank.entity.User;

import java.security.Principal;
import java.util.List;

public interface DeposService {
    void createDepos(Principal user, DeposDto deposDto);
    List<Deposit> getAll();
    List<Deposit> getConfirm(User user);
    void update(long id,DeposDto deposDto);
}
