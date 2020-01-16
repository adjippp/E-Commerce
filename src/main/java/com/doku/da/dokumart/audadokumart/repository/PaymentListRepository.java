package com.doku.da.dokumart.audadokumart.repository;

import com.doku.da.dokumart.audadokumart.entity.payment.ListPaymentChannel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentListRepository extends JpaRepository<ListPaymentChannel, Integer> {
}
