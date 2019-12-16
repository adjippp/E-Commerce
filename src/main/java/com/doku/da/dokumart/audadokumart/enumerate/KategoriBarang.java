package com.doku.da.dokumart.audadokumart.enumerate;

public enum KategoriBarang {
    FASHION(1),
    BEAUTY(2),
    HOME(3),
    ELECTRONIC(4);

    private final Integer id;

    KategoriBarang(Integer id) {
        this.id=id;
    }

    public Integer getId() {
        return this.id;
    }
}
