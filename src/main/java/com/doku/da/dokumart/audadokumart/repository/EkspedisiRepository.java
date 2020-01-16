package com.doku.da.dokumart.audadokumart.repository;

import com.doku.da.dokumart.audadokumart.entity.Ekspedisi;
import com.doku.da.dokumart.audadokumart.entity.Layanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EkspedisiRepository extends JpaRepository<Ekspedisi, Integer> {
    @Query(value = "SELECT E FROM Ekspedisi E JOIN E.layanans L WHERE L.id = :id")
    public Ekspedisi findByLayanan_Id(@Param("id") Integer id);

}
