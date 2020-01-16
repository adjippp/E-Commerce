package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.entity.payment.ListPaymentChannel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
public class APInvoiceDto extends RepresentationModel {

    private Integer id;

    private Date dateAP;

    private TransaksiDto transaksiDto;

    private EkspedisiDto ekspedisiDto;

    private Double  ekspedisiFee;

    private ListPaymentChannelDto paymentChannelDto;

    private Double  paymentChannelFee;

    private PenjualDto penjualDto;

    private Double  totalAmt;

    private BatchDto batchDto;
}