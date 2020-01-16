package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.dto.PembeliDto;
import com.doku.da.dokumart.audadokumart.entity.Pembeli;
import com.doku.da.dokumart.audadokumart.repository.PembeliRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PembeliService {
    //Method Pembeli bisa bayar
    private List<Pembeli> tempPembeli = new ArrayList<>();

    @Autowired
    private PembeliRepository pembeliRepository;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public List<PembeliDto> getAllPembeli() {
        final List<PembeliDto> collection =
                pembeliRepository
                        .findAll()
                        .stream()
                        .map(pembeli -> dozerBeanMapper.map(pembeli, PembeliDto.class))
                        .collect(Collectors.toList());
        return collection;
    }

    public PembeliDto getPembeliById(Integer id) {
        PembeliDto pembeli = pembeliRepository.findById(id)
                .map(p -> dozerBeanMapper.map(p, PembeliDto.class))
                .orElseThrow(() -> new EntityNotFoundException());
        return pembeli;
    }

    public PembeliDto createPembeli(@RequestBody final Pembeli pembeliFromRequest) {
        return dozerBeanMapper.map(pembeliRepository.save(pembeliFromRequest),PembeliDto.class);
    }

    public PembeliDto getKeranjangByPembeliId(Integer id) {
        return pembeliRepository
                .findById(id)
                .map(keranjang -> dozerBeanMapper.map(keranjang, PembeliDto.class))
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public PembeliDto updateNoHPPembeli(@RequestBody final Pembeli pembeliFromRequest, Integer id) {
        Optional<Pembeli> existingPenjual = pembeliRepository.findById(id);

        final Pembeli pembeli = pembeliFromRequest;

        if (existingPenjual.isPresent())
        {
            Pembeli updatedPenjual = existingPenjual.get();
            updatedPenjual.setNoHP(pembeliFromRequest.getNoHP());
            return dozerBeanMapper.map(pembeliRepository.save(updatedPenjual),PembeliDto.class);
        }
        else
        {
            throw new EntityNotFoundException();
        }
    }
    public void deletePembeliById(Integer id)
    {
        if(pembeliRepository.findById(id).isPresent())
        {
            pembeliRepository.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException();
        }

    }
}
