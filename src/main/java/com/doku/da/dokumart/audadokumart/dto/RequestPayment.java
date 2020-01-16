package com.doku.da.dokumart.audadokumart.dto;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
public class RequestPayment {
    private Integer idPembeli;
    private Integer idTransaksi;
    private Integer account;
    private Integer accountTujuan;
    @Nullable
    private Integer jumlah;
    @Nullable
    private Double fee;
    @Nullable
    private boolean statusPembayaran;
    @Nullable
    private String pesan;
}
