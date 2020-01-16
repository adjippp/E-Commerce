package com.doku.da.dokumart.audadokumart.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ekspedisi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama;

    @ManyToOne
    @JoinColumn(name="id_penjual")
    private Penjual penjual;

    @OneToMany(mappedBy = "ekspedisi")
    private List<Layanan> layanans;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "ekspedisi")
    private List<APInvoice> apInvoice;

    public Ekspedisi(String nama, Penjual penjual, List<Layanan> layanans, List<APInvoice> apInvoices) {
        this.nama = nama;
        this.penjual = penjual;
        this.layanans = layanans;
        this.apInvoice = apInvoices;
    }
    public Ekspedisi(){}

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

    public Penjual getPenjual() {
        return penjual;
    }

    public void setPenjual(Penjual penjual) {
        this.penjual = penjual;
    }

    public List<Layanan> getLayanans() {
        return layanans;
    }

    public void setLayanans(List<Layanan> layanans) {
        this.layanans = layanans;
    }

    public List<APInvoice> getApInvoice() {
        return apInvoice;
    }

    public void setApInvoice(List<APInvoice> apInvoices) {
        this.apInvoice = apInvoices;
    }
}