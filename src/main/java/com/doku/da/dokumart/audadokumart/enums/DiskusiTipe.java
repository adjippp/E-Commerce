package com.doku.da.dokumart.audadokumart.enums;

public enum DiskusiTipe {
    TANYA(1),
    JAWAB(2);

    private final Integer value;

    DiskusiTipe(final Integer newValue) {
        value = newValue;
    }

    public Integer getValue() { return value; }
}
