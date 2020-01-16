package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.dto.*;
import com.doku.da.dokumart.audadokumart.entity.Keranjang;
import com.doku.da.dokumart.audadokumart.entity.KeranjangDetail;
import com.doku.da.dokumart.audadokumart.repository.KeranjangRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KeranjangService {
    @Autowired
    private KeranjangRepository keranjangRepository;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public List<KeranjangDto> getAllKeranjang(){
        final List<KeranjangDto> collection =
                keranjangRepository
                        .findAll()
                        .stream()
                        .map(keranjang -> dozerBeanMapper.map(keranjang, KeranjangDto.class))
                        .collect(Collectors.toList());
        return collection;
    }

    //Bisa Nampilin isi Barang dalam Keranjang ID tertentu
    public KeranjangDto getKeranjangById(Integer id) {
        return keranjangRepository
                .findById(id)
                .map(keranjang -> dozerBeanMapper.map(keranjang, KeranjangDto.class))
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public KeranjangDto getAllIsiKeranjangByPembeliId(Integer id) {
        KeranjangDto keranjangDto = Optional.of(keranjangRepository
                .findByPembeli_Id(id))
                .map(keranjang -> dozerBeanMapper.map(keranjang, KeranjangDto.class))
                .orElseThrow(() -> new EntityNotFoundException());
        return keranjangDto;
    }

    public KeranjangDto createKeranjang(@RequestBody final Keranjang keranjang)
    {
        return dozerBeanMapper.map(keranjangRepository.save(keranjang), KeranjangDto.class);
    }
}
