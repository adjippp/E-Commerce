package com.doku.da.dokumart.audadokumart.entity;

import com.doku.da.dokumart.audadokumart.dto.DiskusiDto;
import com.doku.da.dokumart.audadokumart.enums.DiskusiTipe;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class DiskusiJawab extends Diskusi {

    public DiskusiJawab(){}

    public DiskusiJawab(Integer id, Barang barang, String konten, Pembeli pembeli, Integer tipe) {
        super(id, barang, konten, pembeli, tipe);
    }
}
