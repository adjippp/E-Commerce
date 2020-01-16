package com.doku.da.dokumart.audadokumart.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Layanan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nama, estimasi;
    private float beratMinimum, beratMaksimum;
    private double tarif;

    @ManyToOne
    @JoinColumn(name = "id_ekspedisi")
    private Ekspedisi ekspedisi;

    public Layanan(){}

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

    public String getEstimasi() {
        return estimasi;
    }

    public void setEstimasi(String estimasi) {
        this.estimasi = estimasi;
    }

    public float getBeratMinimum() {
        return beratMinimum;
    }

    public void setBeratMinimum(float beratMinimum) {
        this.beratMinimum = beratMinimum;
    }

    public float getBeratMaksimum() {
        return beratMaksimum;
    }

    public void setBeratMaksimum(float beratMaksimum) {
        this.beratMaksimum = beratMaksimum;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public void setEkspedisi(Ekspedisi ekspedisi) {
        this.ekspedisi = ekspedisi;
    }
}
