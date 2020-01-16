package com.doku.da.dokumart.audadokumart.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Keranjang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "keranjang")
    private List<KeranjangDetail> keranjangDetail;

    @Getter
    @Setter
    @OneToOne(mappedBy = "keranjang", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Pembeli pembeli;

    @OneToMany(mappedBy = "keranjang")
    @Nullable
    private List<Transaksi> transaksi;

    public Keranjang(){}

    public Keranjang(Integer id, List<Barang> barangs) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setKeranjangDetail(List<KeranjangDetail> keranjangDetail) {
        this.keranjangDetail = keranjangDetail;
    }

    public List<KeranjangDetail> getKeranjangDetail() {
        return keranjangDetail;
    }


}
