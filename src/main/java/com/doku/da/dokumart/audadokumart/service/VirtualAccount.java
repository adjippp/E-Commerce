package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.service.PaymentChannel;

public interface VirtualAccount extends PaymentChannel {
    String generateVA();
}
