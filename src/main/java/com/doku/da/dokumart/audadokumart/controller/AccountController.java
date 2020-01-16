package com.doku.da.dokumart.audadokumart.controller;

import com.doku.da.dokumart.audadokumart.entity.payment.Account;
import com.doku.da.dokumart.audadokumart.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Account> getAll(){
        return accountService.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Account getById(@PathVariable Integer id){
        Account account = accountService.getById(id);
        return account;
    }

}
