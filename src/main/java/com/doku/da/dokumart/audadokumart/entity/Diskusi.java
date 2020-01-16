package com.doku.da.dokumart.audadokumart.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Diskusi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = ("barang_id"))
    private Barang barang;

    @ManyToOne
    @JoinColumn(name="pembeli_id")
    private Pembeli pembeli;

    private String konten;
    private Integer tipe;
    private Timestamp sentTime;

    public Diskusi(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Barang getBarang() {
        return barang;
    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public Integer getTipe() {
        return tipe;
    }

    public void setTipe(Integer tipe) {
        this.tipe = tipe;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    public Timestamp getSentTime() {
        return sentTime;
    }

    public void setSentTime(Timestamp sentTime) {
        this.sentTime = sentTime;
    }

    public Diskusi(Integer id, Barang barang, String konten, Pembeli pembeli, Integer tipe) {
        this.id = id;
        Barang barangTemp = barang;
        barangTemp.setChatRooms(null);
        this.barang = barangTemp;
        this.konten = konten;
        this.tipe = tipe;
        Pembeli pembeliTemp = pembeli;
        pembeliTemp.setKeranjang(null);
        this.pembeli = pembeliTemp;
    }
}
