package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.dto.BatchDto;
import com.doku.da.dokumart.audadokumart.dto.ResponseResi;
import com.doku.da.dokumart.audadokumart.dto.TransaksiDto;
import com.doku.da.dokumart.audadokumart.entity.APInvoice;
import com.doku.da.dokumart.audadokumart.entity.Batch;
import com.doku.da.dokumart.audadokumart.entity.Transaksi;
import com.doku.da.dokumart.audadokumart.repository.BatchRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BatchService {
    @Autowired
    private BatchRepository batchRepository;

    private BatchDto batchDto;

    @Autowired
    private TransaksiService transaksiService;

    @Autowired
    private ResponseResi responseResi;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public List<BatchDto> getAllBatch() {
        List<BatchDto> allBatch = batchRepository
                .findAll()
                .stream()
                .map(batch -> dozerBeanMapper.map(batch, BatchDto.class))
                .collect(Collectors.toList());
        return allBatch;
    }

    public BatchDto getBatchById(Integer id) {
        return batchRepository
                .findById(id)
                .map(batch -> dozerBeanMapper.map(batch, BatchDto.class))
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public BatchDto createBatch(@RequestBody Batch batch) {
        return dozerBeanMapper.map(batchRepository.save(batch), BatchDto.class);
    }

    public String generateResi(){
        Integer max = 999999999;
        Integer min = 100000000;
        Random r= new Random();

        return String.valueOf(min+r.nextInt(max));
    }

    public ResponseResi KirimBarang(Integer idTransaksi) {
        TransaksiDto cekTransaksi = transaksiService.getTrxById(idTransaksi);
        if(cekTransaksi != null){
            responseResi.setIdTransaksi(idTransaksi);
            responseResi.setResi(this.generateResi());
            responseResi.setStatusPengiriman("Barang sudah sampai");
        } else {
            responseResi.setStatusPengiriman("Barang belum sampai");
        }
        return responseResi;
    }
}
