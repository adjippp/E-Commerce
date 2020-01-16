package com.doku.da.dokumart.audadokumart.common.exception;

public class PenjualNotFoundException extends RuntimeException  {
    private final Long id;
    public PenjualNotFoundException(final long id) {
        super("Penjual could not be found with id: " + id);
        this.id = id;
    }
}
