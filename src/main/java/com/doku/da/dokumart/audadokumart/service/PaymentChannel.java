package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.interfaces.Client;
import org.springframework.stereotype.Component;

@Component
public interface PaymentChannel extends Client {
    boolean bayar();
    Double hitungFee();
}
