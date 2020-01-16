package com.doku.da.dokumart.audadokumart.controller;


import com.doku.da.dokumart.audadokumart.dto.ListPaymentChannelDto;
import com.doku.da.dokumart.audadokumart.dto.PaymentDto;
import com.doku.da.dokumart.audadokumart.dto.RequestPayment;
import com.doku.da.dokumart.audadokumart.entity.payment.ListPaymentChannel;
import com.doku.da.dokumart.audadokumart.dto.WalletDto;
import com.doku.da.dokumart.audadokumart.service.PaymentService;
import com.doku.da.dokumart.audadokumart.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentchannels")
public class PaymentCore {
    @Autowired
    WalletService walletService;

    @Autowired
    PaymentService paymentService;

    @GetMapping
    public ResponseEntity<CollectionModel<ListPaymentChannelDto>> getAll(){
        return ResponseEntity.ok(paymentService.getAll());
    }

    @GetMapping(value = "/Wallets", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WalletDto> getAllWallet(){
        return  walletService.getAll();
    }

    @GetMapping(value = "/Wallets/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public WalletDto getByIdWallet(@PathVariable Integer id){
        return walletService.getById(id);
    }

    @PostMapping(value = "/Wallets/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity bayar(@RequestBody PaymentDto paymentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.pembayaran(paymentDto));
    }
}