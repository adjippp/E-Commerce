package com.doku.da.dokumart.audadokumart.repository;

import com.doku.da.dokumart.audadokumart.entity.KeranjangDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KeranjangDetailRepository extends JpaRepository <KeranjangDetail, Integer> {

    @Query(value = "SELECT k FROM KeranjangDetail k WHERE k.keranjang.id = :idKeranjang AND k.barang.id = :idBarang ")
    public KeranjangDetail findBykeranjang_idAndbarang_id(
            @Param("idKeranjang") Integer idKeranjang,
            @Param("idBarang") Integer idBarang);

    @Query(value = "SELECT k FROM KeranjangDetail k WHERE k.keranjang.id = :idKeranjang")
    public List<KeranjangDetail> findBykeranjang_id(@Param("idKeranjang") Integer idKeranjang);

    @Modifying
    @Query(value = "DELETE FROM KeranjangDetail k WHERE k.keranjang.id= :idKeranjang")
    public void deleteByKeranjang_id(@Param("idKeranjang") Integer idKeranjang);

}
