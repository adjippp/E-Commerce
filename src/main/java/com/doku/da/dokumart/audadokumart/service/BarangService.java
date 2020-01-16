package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.common.exception.BarangNotFoundException;
import com.doku.da.dokumart.audadokumart.entity.Barang;
import com.doku.da.dokumart.audadokumart.repository.BarangRepository;
import com.doku.da.dokumart.audadokumart.dto.BarangDto;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BarangService {

    private List<Barang> tempBarang = new ArrayList<>();

    @Autowired
    private BarangRepository barangRepository;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public List<BarangDto> getAllBarang() {
        final List<BarangDto> collection =
                barangRepository
                        .findAll()
                        .stream()
                        .map(barang -> dozerBeanMapper.map(barang, BarangDto.class))
                        .collect(Collectors.toList());
        return collection;
    }

    public BarangDto createBarang(@RequestBody final BarangDto barangFromRequest) {
        Barang barang = dozerBeanMapper.map(barangFromRequest,Barang.class);
        return dozerBeanMapper.map(barangRepository.save(barang), BarangDto.class);
    }

    public BarangDto updateBarang(@RequestBody final BarangDto barangFromRequest, Integer id) {
        Optional<Barang> existingBarang = barangRepository.findById(id);

        final Barang barang = dozerBeanMapper.map(barangFromRequest,Barang.class);;

        if (existingBarang.isPresent())
        {
            Barang updatedBarang = existingBarang.get();
            updatedBarang.setBerat(barangFromRequest.getBerat());
            updatedBarang.setHarga(barangFromRequest.getHarga());
            updatedBarang.setKategori(barangFromRequest.getKategori());
            updatedBarang.setNama(barangFromRequest.getNama());
            updatedBarang.setStok(barangFromRequest.getStok());
            return dozerBeanMapper.map(barangRepository.save(updatedBarang),BarangDto.class);
            //return barangRepository.findById(id).map(dozerBeanMapper.map(updatedBarang,BarangDto.class));
        }return null;
    }

    public BarangDto getBarangById(Integer id) {
        return barangRepository
                .findById(id)
                .map(barang -> dozerBeanMapper.map(barang, BarangDto.class))
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public List<BarangDto> getAllBarangByPenjualId(Integer id) {
        final List<BarangDto> collection =
                barangRepository
                        .findByPenjual_Id(id)
                        .stream()
                        .map(barang -> dozerBeanMapper.map(barang, BarangDto.class))
                        .collect(Collectors.toList());
        return collection;
    }

    public List<BarangDto> getAllBarangByPenjualIdByKategori(Integer idPenjual, Integer idKategori) {
        final List<BarangDto> collection =
                barangRepository
                        .findByPenjual_idAndKategori_Id(idPenjual,idKategori)
                        .stream()
                        .map(barang -> dozerBeanMapper.map(barang, BarangDto.class))
                        .collect(Collectors.toList());
        return collection;
    }

    public List<BarangDto> getAllBarangByKategoriId(Integer id) {
        final List<BarangDto> collection =
                barangRepository
                        .findByKategori_Id(id)
                        .stream()
                        .map(barang -> dozerBeanMapper.map(barang, BarangDto.class))
                        .collect(Collectors.toList());
        return collection;
    }


    public void deleteBarangById(Integer id)
    {
        if(barangRepository.findById(id).isPresent())
        {
            barangRepository.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException();
        }
    }


    public Integer getTotalBarangByKategori(Integer idKategori) {
        Integer temp=barangRepository.getTotalStockByIdKategori(idKategori);
        return temp;
    }
}