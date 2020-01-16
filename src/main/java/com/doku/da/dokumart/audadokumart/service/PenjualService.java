package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.dto.BarangDto;
import com.doku.da.dokumart.audadokumart.entity.Barang;
import com.doku.da.dokumart.audadokumart.entity.Penjual;
import com.doku.da.dokumart.audadokumart.repository.PenjualRepository;
import com.doku.da.dokumart.audadokumart.dto.PenjualDto;
import com.doku.da.dokumart.audadokumart.dto.BaseResponseDto;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PenjualService {

    private List<Penjual> tempPenjual = new ArrayList<>();
    @Autowired
    private PenjualRepository penjualRepository;
    @Autowired
    private BaseResponseDto baseResponseDto;
    @Autowired

    private DozerBeanMapper dozerBeanMapper;

    //contoh yang salah, ResponseEntity tidak boleh digunakan pada service, hanya pada controller
    public ResponseEntity<CollectionModel<PenjualDto>> getAllPenjual() {
        final List<PenjualDto> collection =
                penjualRepository
                        .findAll()
                        .stream()
                        .map(p -> dozerBeanMapper.map(p, PenjualDto.class))
                        .collect(Collectors.toList());
        final CollectionModel<PenjualDto> resources = new CollectionModel<>(collection);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resources);
    }

    public PenjualDto getPenjualById(Integer id) {
        PenjualDto penjual = penjualRepository.findById(id)
                .map(p -> dozerBeanMapper.map(p, PenjualDto.class))
                .orElseThrow(() -> new EntityNotFoundException());
        return penjual;
    }

    public PenjualDto createPenjual(@RequestBody final PenjualDto penjualFromRequest) {
        Penjual penjual = dozerBeanMapper.map(penjualFromRequest,Penjual.class);
        return dozerBeanMapper.map(penjualRepository.save(penjual),PenjualDto.class);
    }

    public PenjualDto updateSaldoPenjual(@RequestBody final PenjualDto penjualFromRequest, Integer id) {
        Optional<Penjual> existingPenjual = penjualRepository.findById(id);

        final Penjual penjual = dozerBeanMapper.map(penjualFromRequest,Penjual.class);;

        if (existingPenjual.isPresent())
        {
            Penjual updatedPenjual = existingPenjual.get();
            updatedPenjual.setSaldo(penjualFromRequest.getSaldo());
            return dozerBeanMapper.map(penjualRepository.save(updatedPenjual),PenjualDto.class);
        }
        else
        {
            throw new EntityNotFoundException();
        }
    }

    public PenjualDto getPenjualByBarangId(Integer id) {
        PenjualDto penjual = Optional.of(penjualRepository.findByBarang_Id(id))
                .map(p -> dozerBeanMapper.map(p, PenjualDto.class))
                .orElseThrow(() -> new EntityNotFoundException());
        return penjual;
    }

    public void deletePenjualById(Integer id)
    {
        if(penjualRepository.findById(id).isPresent())
        {
            penjualRepository.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException();
        }
    }
}
