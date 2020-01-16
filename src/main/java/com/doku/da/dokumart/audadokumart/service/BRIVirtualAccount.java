package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.entity.payment.Account;
import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class BRIVirtualAccount implements VirtualAccount {

    private Account accountTujuan;
    private Account account;
    private Integer nilaiTransaksi;
    private Double fee;

     public void setParam(Account account, Account accountTujuan, Integer nilai){
        this.account = account;
        this.accountTujuan = accountTujuan;
        this.nilaiTransaksi = nilai;
    }

    @Override
    public String generateVA() {
        System.out.println("0777"+accountTujuan.getId());
        Random rn = new Random();
        String VACode = "0777"+accountTujuan.getId();
        for (int i = 0; i < 5; i++){
            VACode = VACode + rn.nextInt();
        }
        return VACode;
    }

    @Override
    public boolean bayar() {
        System.out.println("transaksi dengan Virtual Account :"+accountTujuan.getId()+" dari :"+account.getId()+" senilai :"+nilaiTransaksi+" status : berhasil");
        return true;
    }

    @Override
    public Double hitungFee() {
        System.out.println(String.valueOf(fee * nilaiTransaksi));
        return Math.ceil(fee*nilaiTransaksi);
    }
}
