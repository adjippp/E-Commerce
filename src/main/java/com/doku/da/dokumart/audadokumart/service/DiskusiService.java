package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.dto.DiskusiDto;
import com.doku.da.dokumart.audadokumart.entity.Diskusi;
import com.doku.da.dokumart.audadokumart.entity.DiskusiJawab;
import com.doku.da.dokumart.audadokumart.entity.DiskusiTanya;
import com.doku.da.dokumart.audadokumart.repository.DiskusiRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiskusiService {

    private List<Diskusi> tempDiskusi = new ArrayList<>();

    @Autowired
    private DiskusiRepository diskusiRepository;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public DiskusiDto getDiskusiById(Integer id) {
        return diskusiRepository
                .findById(id)
                .map(diskusi -> dozerBeanMapper.map(diskusi, DiskusiDto.class))
                .orElseThrow(() -> new EntityNotFoundException());
    }

    public DiskusiDto createDiskusiTanya(final Diskusi diskusiTanyaFromRequest) {
        Timestamp tempTime = new Timestamp(System.currentTimeMillis());
        diskusiTanyaFromRequest.setSentTime(tempTime);
        DiskusiTanya diskusiTanya = dozerBeanMapper.map(diskusiTanyaFromRequest, DiskusiTanya.class);
        return dozerBeanMapper.map(diskusiRepository.save(diskusiTanya),DiskusiDto.class);
    }

    public DiskusiDto createDiskusiJawab(final Diskusi diskusiJawabFromRequest) {
        Timestamp tempTime = new Timestamp(System.currentTimeMillis());
        diskusiJawabFromRequest.setSentTime(tempTime);
        DiskusiJawab diskusiJawab = dozerBeanMapper.map(diskusiJawabFromRequest, DiskusiJawab.class);
        return dozerBeanMapper.map(diskusiRepository.save(diskusiJawab),DiskusiDto.class);
    }

    public List<DiskusiDto> getDiskusiByBarangId(Integer id)
    {
        final List<DiskusiDto> collection =
                diskusiRepository
                        .findByBarang_Id(id)
                        .stream()
                        .map(diskusi -> dozerBeanMapper.map(diskusi, DiskusiDto.class))
                        .collect(Collectors.toList());
        return collection;
    }

}