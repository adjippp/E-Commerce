package com.doku.da.dokumart.audadokumart.repository;

import com.doku.da.dokumart.audadokumart.entity.APInvoice;
import com.doku.da.dokumart.audadokumart.entity.Barang;
import com.doku.da.dokumart.audadokumart.entity.Penjual;
import com.doku.da.dokumart.audadokumart.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface APInvoiceRepository extends JpaRepository <APInvoice, Integer> {

    @Query(value = "SELECT a FROM APInvoice a JOIN a.transaksi b WHERE b.id = :id ")
    public APInvoice findByTransaksi_Id(@Param("id") Integer id);
}
