package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.controller.APInvoiceController;
import com.doku.da.dokumart.audadokumart.dto.*;
import com.doku.da.dokumart.audadokumart.entity.APInvoice;
import com.doku.da.dokumart.audadokumart.entity.Ekspedisi;
import com.doku.da.dokumart.audadokumart.entity.Transaksi;
import com.doku.da.dokumart.audadokumart.entity.payment.ListPaymentChannel;
import com.doku.da.dokumart.audadokumart.interfaces.Client;
import com.doku.da.dokumart.audadokumart.repository.APInvoiceRepository;
import org.dozer.DozerBeanMapper;
import com.doku.da.dokumart.audadokumart.common.exception.CustomException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
public class APInvoiceService {

    @Autowired
    private APInvoiceRepository apInvoiceRepository;

    private ModelMapper modelMapper;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Autowired
    private PaymentChannel paymentChannel;

    @Autowired
    private EkspedisiService ekspedisiService;

    public List<APInvoiceDto> getAll(){
        final List<APInvoiceDto> collection =
                apInvoiceRepository
                        .findAll()
                        .stream()
                        .map(apInvoice -> dozerBeanMapper.map(apInvoice, APInvoiceDto.class))
                        .collect(Collectors.toList());
        return collection;
    }

    public APInvoiceDto getbyID(Integer id){
        APInvoiceDto apInvoiceDto =
                apInvoiceRepository
                        .findById(id)
                        .map(apInvoice -> dozerBeanMapper.map(apInvoice, APInvoiceDto.class))
                        .orElseThrow(() -> new CustomException(id, "AP Invoice"));
        return apInvoiceDto;
    }

    public APInvoiceDto create(APInvoiceDto apInvoiceDtoInput){
        TransaksiDto transaksiDto = apInvoiceDtoInput.getTransaksiDto();
        Transaksi transaksiMap = dozerBeanMapper.map(transaksiDto, Transaksi.class);

        EkspedisiDto ekspedisiDto = apInvoiceDtoInput.getEkspedisiDto();
        Ekspedisi ekspedisiMap = dozerBeanMapper.map(ekspedisiDto, Ekspedisi.class);

        ListPaymentChannelDto listPaymentChannelDto = apInvoiceDtoInput.getPaymentChannelDto();
        ListPaymentChannel paymentChannelMap = dozerBeanMapper.map(listPaymentChannelDto, ListPaymentChannel.class);

        APInvoice apInvoiceInput = dozerBeanMapper.map(apInvoiceDtoInput, APInvoice.class);

        apInvoiceInput.setTransaksi(transaksiMap);
        apInvoiceInput.setEkspedisi(ekspedisiMap);
        apInvoiceInput.setListPaymentChannel(paymentChannelMap);

        Double payChannelFee = paymentChannel.hitungFee();
        apInvoiceInput.setPaymentChannelFee(payChannelFee);

        Double ekspedisiFee; // apInvoiceInput.getTransaksi().getKeranjang().getId();
        ekspedisiFee = ekspedisiService.hitungBiaya();
        apInvoiceInput.setEkspedisiFee(ekspedisiFee);

        Double amtJual = apInvoiceInput.getTransaksi().getTotalAmt();
        apInvoiceInput.setTotalAmtJual(amtJual);

        final APInvoice save = apInvoiceRepository.save(apInvoiceInput);
        APInvoiceDto apInvoiceDto = dozerBeanMapper.map(save, APInvoiceDto.class);
        return apInvoiceDto;
    }

}