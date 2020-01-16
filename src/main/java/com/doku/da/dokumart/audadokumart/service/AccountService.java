package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.controller.AccountController;
import com.doku.da.dokumart.audadokumart.entity.payment.Account;
import com.doku.da.dokumart.audadokumart.repository.AccountRepository;
import com.doku.da.dokumart.audadokumart.common.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;

import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAll(){
        List<Account> listAccount = accountRepository.findAll();
        Link link;
        for(Account account : listAccount){
            link = linkTo(AccountController.class).slash(account.getId()).withRel("Detail");
            account.add(link);
        }
        return listAccount;
    }

    public Account getById(Integer id){
        return accountRepository.findById(id).orElseThrow(() -> new CustomException(id,"Account"));
    }

    public void insert(Account account){
        accountRepository.save(account);
    }
}
