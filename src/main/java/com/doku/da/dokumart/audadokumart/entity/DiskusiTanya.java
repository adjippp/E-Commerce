package com.doku.da.dokumart.audadokumart.entity;

import com.doku.da.dokumart.audadokumart.enums.DiskusiTipe;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class DiskusiTanya extends Diskusi {

    public DiskusiTanya(){}

    public DiskusiTanya(Integer id, Barang barang, String konten, Pembeli pembeli, Integer tipe) {
        super(id, barang, konten, pembeli, tipe);
    }
}
