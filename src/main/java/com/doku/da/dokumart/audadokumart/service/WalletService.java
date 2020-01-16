package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.entity.payment.Account;
import com.doku.da.dokumart.audadokumart.dto.WalletDto;

import com.doku.da.dokumart.audadokumart.repository.WalletRespository;
import com.doku.da.dokumart.audadokumart.common.exception.CustomException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletService implements PaymentChannel {

    private Account account;
    private Account accountTujuan;
    private Integer nilai;

    private final Double fee = 2500.0;

    @Autowired
    WalletRespository walletRespository;

    @Autowired
    AccountService accountService;

    public List<WalletDto> getAll(){
        return walletRespository.findAll().stream().map(WalletDto::new).collect(Collectors.toList());
    }

    public WalletDto getById(Integer id){
        return walletRespository.findById(id).map(WalletDto::new).orElseThrow(() -> new CustomException(id,"Wallet"));
    }

    public void setParam(Account account, Account accountTujuan, Integer nilai){
        this.account = account;
        this.accountTujuan = accountTujuan;
        this.nilai = nilai;
    }

    @Override
    public boolean bayar() {
        // cek saldo akun
        if (account.getSaldo() > nilai){
            // saldo mencukupi untuk transaksi
            account.setSaldo(account.getSaldo() - nilai);
            accountService.insert(account);
            accountTujuan.setSaldo(accountTujuan.getSaldo() + nilai);
            accountService.insert(accountTujuan);
            return true;
        }else {
            // saldo tidak mencukupi untuk transaksi
            return false;
        }
    }

    @Override
    public Double hitungFee() {
        return fee;
    }
}