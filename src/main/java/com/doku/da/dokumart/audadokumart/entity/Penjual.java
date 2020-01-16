package com.doku.da.dokumart.audadokumart.entity;

import com.doku.da.dokumart.audadokumart.interfaces.Client;
//import com.sun.javafx.beans.IDProperty;
//import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
public class Penjual implements Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama;
    private Double saldo;
    private String kota;

    @OneToMany(mappedBy = "penjual")
    private List<Barang> barangs;

    @OneToMany(mappedBy = "penjual")
    private List<Ekspedisi> ekspedisis;

    @OneToMany(mappedBy = "penjual")
    private List<PaymentPartnerModel> paymentPartnerModels;

//    @ManyToMany
//    @JoinTable(name = "penjual_transaksi",
//            joinColumns = @JoinColumn(name = "id_penjual", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "id_transaksi",
//                    referencedColumnName = "id"))
//    private List<Transaksi> transaksis;

    @OneToMany(mappedBy = "penjual")
    private List<APInvoice> apInvoice;

    public Penjual(){}

    public Penjual(Integer id, String nama, Double saldo, String kota) {
        this.id = id;
        this.nama = nama;
        this.saldo = saldo;
        this.kota = kota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }
}
