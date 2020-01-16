package com.doku.da.dokumart.audadokumart.entity;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Entity
public class KeranjangDetail{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "keranjang_id")
    private Keranjang keranjang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "barang_id")
    private Barang barang;

    private Integer quantity;

    private Double amountByQuantity;

    private Float beratByQuantity;

    public KeranjangDetail(){}

    public KeranjangDetail(Integer id, Keranjang keranjang, Barang barang, Integer quantity) {
        this.id = id;
        this.keranjang = keranjang;
        this.barang = barang;
        this.quantity = quantity;
    }

    public Float getBeratByQuantity() {
        return beratByQuantity;
    }

    public void setBeratByQuantity(Float beratByQuantity) {
        this.beratByQuantity = beratByQuantity;
    }

    public Double getAmountByQuantity() {
        return amountByQuantity;
    }

    public void setAmountByQuantity(Double amountByQuantity) {
        this.amountByQuantity = amountByQuantity;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setKeranjang(Keranjang keranjang) {
        this.keranjang = keranjang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Keranjang getKeranjang() {
        return keranjang;
    }

    public Barang getBarang() {
        return barang;
    }


}
