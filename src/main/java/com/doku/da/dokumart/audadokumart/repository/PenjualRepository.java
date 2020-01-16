package com.doku.da.dokumart.audadokumart.repository;

import com.doku.da.dokumart.audadokumart.entity.Barang;
import com.doku.da.dokumart.audadokumart.entity.Penjual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.DoubleStream;

@Repository
public interface PenjualRepository extends JpaRepository <Penjual, Integer> {

    public Penjual findOneById(Integer id);

    @Query(value = "SELECT p FROM Penjual p JOIN p.barangs b WHERE b.id = :id ")
    public Penjual findByBarang_Id(@Param("id") Integer id);


}
