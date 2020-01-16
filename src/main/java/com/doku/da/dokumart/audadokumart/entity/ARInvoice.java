package com.doku.da.dokumart.audadokumart.entity;

import com.doku.da.dokumart.audadokumart.interfaces.Invoice;

import javax.persistence.*;

@Entity
public class ARInvoice implements Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_transaksi")
    private Transaksi transaksi;

}
