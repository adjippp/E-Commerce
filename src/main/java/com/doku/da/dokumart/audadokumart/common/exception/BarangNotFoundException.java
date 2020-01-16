package com.doku.da.dokumart.audadokumart.common.exception;

public class BarangNotFoundException extends RuntimeException {
    private final Long id;
    public BarangNotFoundException(final long id) {
        super("Barang could not be found with id: " + id);
        this.id = id;
    }
}
