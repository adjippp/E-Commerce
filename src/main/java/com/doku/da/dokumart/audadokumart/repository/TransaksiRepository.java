package com.doku.da.dokumart.audadokumart.repository;

import com.doku.da.dokumart.audadokumart.entity.Barang;
import com.doku.da.dokumart.audadokumart.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {

    @Query(value = "SELECT a FROM Transaksi a WHERE a.apInvoice.id = :id ")
    public Transaksi findByAPInvoice_Id(@Param("id") Integer id);

    /*new com.doku.da.dokumart.audadokumart.KeranjangDetail */
    @Query(value = "select sum(kd.quantity) from KeranjangDetail kd Where kd.keranjang.id = :id")
    public Integer getTotalQty(@Param("id") Integer id);

    //select sum(kd.quantity) from KeranjangDetail kd Where kd.keranjang.id = :id

    @Query(value = "select sum(amountByQuantity)" +
            "from KERANJANGDETAIL join KERANJANG on KERANJANGDETAIL.KERANJANG_ID = KERANJANG.ID" +
            " where KERANJANG.ID = :id", nativeQuery = true)
    public Double getTotalAmt(@Param("id") Integer id);

    @Query(value = "select sum(beratByQuantity)" +
            "from KERANJANGDETAIL join KERANJANG on KERANJANGDETAIL.KERANJANG_ID = KERANJANG.ID" +
            " where KERANJANG.ID = :id", nativeQuery = true)
    public Float getTotalBobot(@Param("id") Integer id);
}
