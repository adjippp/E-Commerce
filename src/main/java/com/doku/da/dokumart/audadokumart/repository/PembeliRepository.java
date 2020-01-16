package com.doku.da.dokumart.audadokumart.repository;

import com.doku.da.dokumart.audadokumart.entity.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PembeliRepository extends JpaRepository <Pembeli, Integer> {

    @Query(value = "SELECT p FROM Pembeli p JOIN p.keranjang k WHERE k.id = :id ")
    public List<Pembeli> findByKeranjang_Id(@Param("id") Integer id);

}
