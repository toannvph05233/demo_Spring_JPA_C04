package com.demo_jpa_c04.service.impl;

import com.demo_jpa_c04.model.Account;
import com.demo_jpa_c04.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl {
    @Autowired
    IAccountRepo iAccountRepo;

    public Account login(String username, String password){
        return iAccountRepo.login(username,password);
    }
}
