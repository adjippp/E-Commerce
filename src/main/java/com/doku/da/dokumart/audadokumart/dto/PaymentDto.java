package com.doku.da.dokumart.audadokumart.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class PaymentDto extends RepresentationModel {
    private Integer idPembeli;
    private Integer idTransaksi;
    private Integer account;
    private Integer jumlah;
    private Double fee;
    private boolean statusPembayaran;
    private String pesan;
}
