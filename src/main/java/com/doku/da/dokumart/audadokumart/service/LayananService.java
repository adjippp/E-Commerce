package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.dto.EkspedisiDto;
import com.doku.da.dokumart.audadokumart.dto.LayananDto;
import com.doku.da.dokumart.audadokumart.entity.Layanan;
import com.doku.da.dokumart.audadokumart.repository.LayananRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LayananService {

    @Autowired
    private LayananRepository layananRepository;

    private LayananDto layananDto;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public List<LayananDto> getAllLayanan() {
        List<LayananDto> semuaLayanan = layananRepository
                .findAll()
                .stream()
                .map(layanan -> dozerBeanMapper.map(layanan, LayananDto.class))
                .collect(Collectors.toList());
        return semuaLayanan;
    }

    public LayananDto createLayanan(@RequestBody final Layanan layanan) {
        return dozerBeanMapper.map(layananRepository.save(layanan), LayananDto.class);
    }

    public LayananDto getLayananById(Integer id) {
        return layananRepository
                .findById(id)
                .map(layanan-> dozerBeanMapper.map(layanan, LayananDto.class))
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public List <LayananDto> getLayananByEkspedisiId(Integer id) {
        List<LayananDto> allLayanan =
                layananRepository.findByEkspedisi_Id(id)
                        .stream()
                        .map(layanan -> dozerBeanMapper.map(layanan, LayananDto.class))
                        .collect(Collectors.toList());
        return allLayanan;
    }

    public LayananDto updateLayanan(@RequestBody Layanan layanan, Integer id) {
        Optional<Layanan> cekLayanan = layananRepository.findById(id);
        if (cekLayanan.isPresent()) {
            return dozerBeanMapper.map(layananRepository.save(layanan), LayananDto.class);
        } else {
            return null;
        }
    }

    public void deleteLayanan(Integer id){
        if (layananRepository.findById(id).isPresent()){
            layananRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }

}
