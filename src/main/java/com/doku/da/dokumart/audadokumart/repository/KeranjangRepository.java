package com.doku.da.dokumart.audadokumart.repository;

import com.doku.da.dokumart.audadokumart.entity.Keranjang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KeranjangRepository extends JpaRepository<Keranjang, Integer> {
    @Query(value = "SELECT k FROM Keranjang k JOIN k.pembeli p WHERE p.id = :id ")
    public Keranjang findByPembeli_Id(@Param("id") Integer id);
}