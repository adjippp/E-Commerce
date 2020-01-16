package com.doku.da.dokumart.audadokumart.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama;

    @OneToMany(mappedBy = "kategori", cascade = CascadeType.ALL)
    private List<Barang> barangs;

    public Kategori (){}

    public Kategori(Integer id, String nama) {
        this.id = id;
        this.nama = nama;
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
}
