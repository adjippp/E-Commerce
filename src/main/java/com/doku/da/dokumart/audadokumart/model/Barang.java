package com.doku.da.dokumart.audadokumart.model;

import com.doku.da.dokumart.audadokumart.enumerate.KategoriBarang;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "MASTER_BARANG")
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idBarang;
    Integer penjualId;
    String namaBarang;
    Integer idKategori;
    Double harga;
    Integer stok;
    Float berat;

    public Barang(){}

    @Autowired
    public Barang(Integer idBarang, Integer penjualId, String namaBarang, Integer idKategori, Double harga, Integer stok, Float berat) {
        this.idBarang = idBarang;
        this.penjualId = penjualId;
        this.namaBarang = namaBarang;
        this.idKategori = idKategori;
        this.harga = harga;
        this.stok = stok;
        this.berat = berat;
    }

    public Integer getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(Integer idBarang) {
        this.idBarang = idBarang;
    }

    public Integer getPenjualId() {
        return penjualId;
    }

    public void setPenjualId(Integer penjualId) {
        this.penjualId = penjualId;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Integer getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(Integer idKategori) {
        this.idKategori = idKategori;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public Float getBerat() {
        return berat;
    }

    public void setBerat(Float berat) {
        this.berat = berat;
    }
}
