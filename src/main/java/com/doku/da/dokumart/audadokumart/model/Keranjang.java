package com.doku.da.dokumart.audadokumart.model;


import java.util.ArrayList;
import java.util.List;

public class Keranjang {
    List<Barang> isiKeranjang = new ArrayList<Barang>();

    public Keranjang(){}
    public Keranjang(List<Barang> isiKeranjang) {
        this.isiKeranjang = isiKeranjang;
    }

    public List<Barang> getIsiKeranjang() {
        return isiKeranjang;
    }

    public void setIsiKeranjang(List<Barang> isiKeranjang) {
        this.isiKeranjang = isiKeranjang;
    }
}
