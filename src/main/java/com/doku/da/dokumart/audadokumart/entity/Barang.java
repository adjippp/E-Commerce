package com.doku.da.dokumart.audadokumart.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( indexes = {@Index(name = "idxBarang", columnList = "id", unique = true)} )
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nama;

    private Double harga;

    @ManyToOne
    @JoinColumn(name = "kategori_id")
    private Kategori kategori;

    private Integer stok;

    private Float berat;

    @ManyToOne
    @JoinColumn(name="penjual_id")
    private Penjual penjual;

    @OneToMany(mappedBy = "barang")
    private List<KeranjangDetail> keranjangDetail;

    @OneToMany(mappedBy = "barang")
    private List<Diskusi> chatRooms;


    public Barang() {
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

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
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

    public Penjual getPenjual() {
        return penjual;
    }

    public void setPenjual(Penjual penjual) {
        this.penjual = penjual;
    }

    public void setChatRooms(List<Diskusi> chatRooms) {
        this.chatRooms = chatRooms;
    }

    public List<Diskusi> getChatRooms() {
        return chatRooms;
    }

    public Barang(Integer id, String nama, Double harga, Kategori kategori, Integer stok, Float berat, Penjual penjual) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
        this.stok = stok;
        this.berat = berat;
        this.penjual = penjual;
    }
}
