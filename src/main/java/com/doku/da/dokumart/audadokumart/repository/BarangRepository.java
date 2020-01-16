package com.doku.da.dokumart.audadokumart.repository;

import com.doku.da.dokumart.audadokumart.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarangRepository extends JpaRepository <Barang, Integer> {
//    public List<Barang> findByid_penjual(Integer id_penjual);
//    public List<Barang> findByid_penjualAndid_kategori(Integer id_penjual, Integer id_kategori);

     @Query(value = "SELECT new com.doku.da.dokumart.audadokumart.entity.Barang (b.id, b.nama, b.harga, b.kategori, b.stok, b.berat, b.penjual) FROM Barang b JOIN b.penjual p WHERE p.id = :id")
      public List<Barang> findByPenjual_Id(@Param("id") Integer id);

    @Query(value = "SELECT b FROM Barang b WHERE b.kategori.id = :id ")
    public List<Barang> findByKategori_Id(@Param("id") Integer id);

    @Query(value = "SELECT b FROM Barang b WHERE b.penjual.id = :idPenjual AND b.kategori.id = :idKategori ")
    public List<Barang> findByPenjual_idAndKategori_Id(@Param("idPenjual") Integer idPenjual, @Param("idKategori") Integer idKategori );

    @Query(value= "SELECT sum(b.stok) FROM Barang b WHERE b.kategori.id = :id")
    public Integer getTotalStockByIdKategori(@Param("id") Integer id);
}
