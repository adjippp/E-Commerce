package com.doku.da.dokumart.audadokumart.repository;

import com.doku.da.dokumart.audadokumart.entity.ARInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ARInvoiceRepository extends JpaRepository<ARInvoice, Integer> {
}
