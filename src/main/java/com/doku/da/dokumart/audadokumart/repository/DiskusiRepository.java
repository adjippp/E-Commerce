package com.doku.da.dokumart.audadokumart.repository;

import com.doku.da.dokumart.audadokumart.entity.Diskusi;
import com.doku.da.dokumart.audadokumart.entity.DiskusiTanya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiskusiRepository extends JpaRepository<Diskusi, Integer> {

//    @Query(value = "SELECT d FROM Diskusi d JOIN d.barang b WHERE b.id = :id")
//    public List<Diskusi> findByBarang_Id(@Param("id") Integer id);

    @Query(value = "SELECT new com.doku.da.dokumart.audadokumart.entity.Diskusi (d.id, d.barang, d.konten, d.pembeli, d.tipe ) FROM Diskusi d JOIN d.barang b WHERE b.id = :id")
    public List<Diskusi> findByBarang_Id(@Param("id") Integer id);

}
