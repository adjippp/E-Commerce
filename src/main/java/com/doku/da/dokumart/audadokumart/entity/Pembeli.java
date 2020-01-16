package com.doku.da.dokumart.audadokumart.entity;

import com.doku.da.dokumart.audadokumart.interfaces.Client;
import com.sun.istack.Nullable;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Pembeli implements Client {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Nullable
    private Integer idWallet;

    @Nullable
    private String nama;

    @Nullable
    private String kota;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Nullable
    private String noHP;

    @OneToOne
    @JoinColumn(name = ("id_keranjang"))
    private Keranjang keranjang;

    @OneToMany(mappedBy = "pembeli")
    private List<Diskusi> chatRooms;

    public Pembeli(Integer id, Integer idWallet, String nama, String kota, String noHP, Keranjang keranjang) {
        this.id = id;
        this.idWallet = idWallet;
        this.nama = nama;
        this.kota = kota;
        this.noHP = noHP;
        this.keranjang = keranjang;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public Keranjang getKeranjang() {
        return keranjang;
    }

    public void setKeranjang(Keranjang keranjang) {
        this.keranjang = keranjang;
    }

    public Integer getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(Integer idWallet) {
        this.idWallet = idWallet;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }
}
