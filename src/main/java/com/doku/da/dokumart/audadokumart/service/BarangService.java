package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.enumerate.KategoriBarang;
import com.doku.da.dokumart.audadokumart.model.Barang;
import com.doku.da.dokumart.audadokumart.repository.BarangRepository;
import com.doku.da.dokumart.audadokumart.response.BaseResponse;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarangService<T> {

    private BarangRepository barangRepository;
    private BaseResponse baseResponse = new BaseResponse();

    @Autowired
    public BarangService(BarangRepository barangRepository) {
        this.barangRepository = barangRepository;
    }

    public List<Barang> getAllBarang() {
        return barangRepository.findAll();
    }

    public List<Barang> getBarangByPenjual(Integer id)
    {
        return barangRepository.findByPenjualId(id);
    }

    public Barang create(Barang barang) {
        return barangRepository.save(barang);
    }

    public Barang update(Barang barang, Integer id)
    {
        Optional<Barang> existingBarang = barangRepository.findById(id);
        if(existingBarang.isPresent())
        {
            Barang updatedBarang = existingBarang.get();

            updatedBarang.setNamaBarang(barang.getNamaBarang());
            updatedBarang.setIdKategori(barang.getIdKategori());
            updatedBarang.setBerat(barang.getBerat());
            updatedBarang.setHarga(barang.getHarga());
            updatedBarang.setPenjualId(barang.getPenjualId());
            updatedBarang.setStok(barang.getStok());
            return barangRepository.save(updatedBarang);
        }
        return null;
    }

    public BaseResponse delete(Integer id)
    {

        Optional<Barang> existingBarang = barangRepository.findById(id);
        if(existingBarang.isPresent())
        {
            barangRepository.deleteById(id);
            baseResponse.setMessage("SUKSES HAPUS BARANG");
            baseResponse.setStatus("SUKSES");
            return baseResponse;
        }
        baseResponse.setMessage("BARANG TIDAK DITEMUKAN");
        baseResponse.setStatus("GAGAL");
        return baseResponse;
    }
}
