package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.dto.ListPaymentChannelDto;
import com.doku.da.dokumart.audadokumart.dto.PaymentDto;
import com.doku.da.dokumart.audadokumart.entity.BlackList;
import com.doku.da.dokumart.audadokumart.entity.payment.*;
import com.doku.da.dokumart.audadokumart.repository.PaymentListRepository;

import lombok.NoArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class PaymentService {

    @Autowired
    BlackListService blackListService;

    @Autowired
    PaymentListRepository paymentListRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    WalletService walletService;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    private Account accountECommerce = new Account(99, "E-Commerce", 0);

    public CollectionModel<ListPaymentChannelDto> getAll(){
        List<ListPaymentChannelDto> listList = paymentListRepository.findAll()
                        .stream()
                        .map(listPaymentChannel -> dozerBeanMapper.map(listPaymentChannel, ListPaymentChannelDto.class))
                        .collect(Collectors.toList());
        CollectionModel<ListPaymentChannelDto> listPaymentChannelDtos = new CollectionModel<>(listList);
        return listPaymentChannelDtos;
    }

    public PaymentDto pembayaran(PaymentDto paymentDto){

        BlackList blackList = blackListService.getByIdPembeli(paymentDto.getIdPembeli());

        if (blackList == null){
               // tidak terdapat dalam blacklist
            Account account = accountService.getById(paymentDto.getAccount());

            walletService.setParam(account, this.accountECommerce, paymentDto.getJumlah());

            boolean statusPembayaran = walletService.bayar();

            paymentDto.setStatusPembayaran(statusPembayaran);

            if (statusPembayaran){
                paymentDto.setPesan("Transaksi Berhasil!");
                paymentDto.setFee(walletService.hitungFee());
            }else {
                paymentDto.setPesan("Transaksi Gagal, Saldo Tidak Cukup ");
            }
        }else{
             // terdapat dalam blacklist
            paymentDto.setPesan("Transaksi Gagal, Akun anda "+blackList.getAlasan());

        }

        return paymentDto;

    }

}
