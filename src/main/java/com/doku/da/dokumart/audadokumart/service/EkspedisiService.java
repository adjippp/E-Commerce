package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.controller.EkspedisiController;
import com.doku.da.dokumart.audadokumart.dto.EkspedisiDto;
import com.doku.da.dokumart.audadokumart.dto.LayananDto;
import com.doku.da.dokumart.audadokumart.dto.ResponseResi;
import com.doku.da.dokumart.audadokumart.dto.TransaksiDto;
import com.doku.da.dokumart.audadokumart.entity.APInvoice;
import com.doku.da.dokumart.audadokumart.entity.Ekspedisi;
import com.doku.da.dokumart.audadokumart.entity.Layanan;
import com.doku.da.dokumart.audadokumart.entity.Transaksi;
import com.doku.da.dokumart.audadokumart.repository.EkspedisiRepository;
import com.doku.da.dokumart.audadokumart.repository.LayananRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
public class EkspedisiService {
    @Autowired
    private EkspedisiRepository ekspedisiRepository;

    @Autowired
    private LayananRepository layananRepository;

    private EkspedisiDto ekspedisiDto;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public List<EkspedisiDto> getAllEkspedisi() {
        List<EkspedisiDto> allEkspedisi = ekspedisiRepository
                .findAll()
                .stream()
                .map(ekspedisi -> dozerBeanMapper.map(ekspedisi, EkspedisiDto.class))
                .collect(Collectors.toList());
        return allEkspedisi;
    }

    public EkspedisiDto getEkspedisiById(Integer id) {
        return ekspedisiRepository
                .findById(id)
                .map(ekspedisi -> dozerBeanMapper.map(ekspedisi, EkspedisiDto.class))
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public EkspedisiDto createEkspedisi(@RequestBody Ekspedisi ekspedisi) {
        return dozerBeanMapper.map(ekspedisiRepository.save(ekspedisi), EkspedisiDto.class);
    }

    public EkspedisiDto getEkspedisiByLayananId(Integer id) {
        EkspedisiDto ekspedisi1 = Optional.of(ekspedisiRepository.findByLayanan_Id(id))
                .map(ekspedisi -> dozerBeanMapper.map(ekspedisi, EkspedisiDto.class))
                .orElseThrow(() -> new EntityNotFoundException());
        return ekspedisi1;
    }

    public EkspedisiDto updateEkspedisi(@RequestBody Ekspedisi ekspedisi, Integer id) {
        Optional<Ekspedisi> cekEkspedisi = ekspedisiRepository.findById(id);

        if (cekEkspedisi.isPresent()) {
            return dozerBeanMapper.map(ekspedisiRepository.save(ekspedisi), EkspedisiDto.class);
        } else{
            return null;
        }
    }

    public void deleteEkspedisi(Integer id){
        if(ekspedisiRepository.findById(id).isPresent()){
            ekspedisiRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public double hitungBiaya() {
//        Float beratTotal = apInvoice.getTransaksi();

        Float beratTotal = (float)9;
        Float beratMax = (float)10;
        Double tarif = 10000.0;
        Double tarifKirim = 0.0;
        if (beratTotal <= beratMax) {
           tarifKirim = tarif;
        } else {
            Float beratSisa = (float)0;
            if (beratTotal%10 != 0){
                beratSisa+=1;
            } else {
                beratSisa+=0;
            }
            Float temp = (beratTotal-(beratTotal%10))/10;
            beratSisa+=temp;
            tarifKirim = beratSisa*tarif;
        }
        return tarifKirim;
    }

}
