package com.doku.da.dokumart.audadokumart.repository;

import com.doku.da.dokumart.audadokumart.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BarangRepository extends JpaRepository <Barang, Integer> {
    List<Barang> findByPenjualId(Integer penjualId);
}
