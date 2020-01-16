package com.doku.da.dokumart.audadokumart.repository;

import com.doku.da.dokumart.audadokumart.entity.Ekspedisi;
import com.doku.da.dokumart.audadokumart.entity.Layanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LayananRepository extends JpaRepository<Layanan, Integer> {
    @Query(value = "SELECT L FROM Layanan L JOIN L.ekspedisi E WHERE E.id = :id")
    public List<Layanan> findByEkspedisi_Id(@Param("id") Integer id);
}
