package com.doku.da.dokumart.audadokumart.constant;

public interface ApiPath {

    String BARANG                                   = "/barang";
    String GET_ALL_BARANG                           = BARANG + "/get";
    String GET_ALL_BARANG_BY_PENJUAL                = BARANG + "/get/penjual";
    String GET_ALL_BARANG_BY_PENJUAL_BY_KATEGORI    = BARANG + "/get/penjual/kategori";
    String UPSERT_BARANG                            = BARANG + "/upsert";
    String DELETE_BARANG                            = BARANG + "/delete";

    String PENJUAL                                  = "/penjual";
    String GET_PENJUAL                              = PENJUAL + "/get";
    String UPSERT_PENJUAL                           = PENJUAL + "/upsert";
    String UPDATE_SALDO_PENJUAL                     = PENJUAL + "/update/saldo/";
    String DELETE_PENJUAL                           = PENJUAL + "/delete";

    String KERANJANG                                = "/keranjang";
    String GET_ALL_ISI_KERANJANG                    = KERANJANG + "/get";
    String UPSERT_KERANJANG                         = KERANJANG + "/upsert";
    String DELETE_KERANJANG                         = KERANJANG + "/delete";

    String DISKUSI                                  = "/diskusi";
    String GET_ALL_DISKUSI_BARANG                   = DISKUSI + "/get/barang";
    String SEND_MESSAGE                             = DISKUSI + "/message";

}
