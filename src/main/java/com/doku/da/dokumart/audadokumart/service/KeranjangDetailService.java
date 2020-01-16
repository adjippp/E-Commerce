package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.dto.BarangDto;
import com.doku.da.dokumart.audadokumart.dto.KeranjangDetailDto;
import com.doku.da.dokumart.audadokumart.dto.PenjualDto;
import com.doku.da.dokumart.audadokumart.entity.Barang;
import com.doku.da.dokumart.audadokumart.entity.Keranjang;
import com.doku.da.dokumart.audadokumart.entity.KeranjangDetail;
import com.doku.da.dokumart.audadokumart.entity.Penjual;
import com.doku.da.dokumart.audadokumart.repository.BarangRepository;
import com.doku.da.dokumart.audadokumart.repository.KeranjangDetailRepository;
import com.doku.da.dokumart.audadokumart.repository.KeranjangRepository;
import lombok.Setter;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KeranjangDetailService {

    @Autowired
    private KeranjangRepository keranjangRepository;

    @Autowired
    private KeranjangDetailRepository keranjangDetailRepository;

    @Autowired
    private BarangRepository barangRepository;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public List<KeranjangDetailDto> getAllKeranjangDetail(){
        final List<KeranjangDetailDto> collection=
                keranjangDetailRepository
                .findAll()
                .stream()
                .map(keranjangDetail -> dozerBeanMapper.map(keranjangDetail,KeranjangDetailDto.class))
                        .collect(Collectors.toList());
        return collection;
    }


    public KeranjangDetailDto getKeranjangDetailById(Integer id) {
        return keranjangDetailRepository
                .findById(id)
                .map(keranjangDetail -> dozerBeanMapper.map(keranjangDetail, KeranjangDetailDto.class))
                .orElseThrow(() -> new EntityNotFoundException());
    }


    public List<KeranjangDetailDto> getAllKeranjangDetailByIdKeranjang(Integer idKeranjang){
        final List<KeranjangDetailDto> collection=
                keranjangDetailRepository
                        .findBykeranjang_id(idKeranjang)
                        .stream()
                        .map(keranjangDetail -> dozerBeanMapper.map(keranjangDetail,KeranjangDetailDto.class))
                        .collect(Collectors.toList());
        return collection;
    }

    public KeranjangDetailDto createKeranjangDetail(@RequestBody final KeranjangDetail keranjangDetail)
    {
        Optional <Barang> barang = null;
        barang = barangRepository.findById(keranjangDetail.getBarang().getId());
        Barang barang1 = barang.get();

        Double temp=calcAmount(keranjangDetail.getQuantity(),barang1.getHarga());
        Float beratTemp = calcWeight(keranjangDetail.getQuantity(),barang1.getBerat());

        keranjangDetail.setAmountByQuantity(temp);
        keranjangDetail.setBeratByQuantity(beratTemp);
        KeranjangDetailDto map = dozerBeanMapper.map(keranjangDetailRepository.save(keranjangDetail), KeranjangDetailDto.class);
        return map;
    }

    public KeranjangDetailDto updateQuantityBarang(@RequestBody final KeranjangDetail keranjangDetail, Integer idKeranjang, Integer idBarang) {

        if(keranjangDetail.getQuantity()==0)
        {
            deleteKeranjangDetailByBarangId(idKeranjang, idBarang);
        }

        else
            {
                Optional<KeranjangDetail> existingDetail =
                        Optional.of(keranjangDetailRepository.findBykeranjang_idAndbarang_id(idKeranjang, idBarang));


                final KeranjangDetail keranjangDetail1 = keranjangDetail;

                if (existingDetail.isPresent())
                {
                    KeranjangDetail updatedKeranjangDetail = existingDetail.get();
                    updatedKeranjangDetail.setQuantity(keranjangDetail.getQuantity());
                    Double temp=calcAmount(updatedKeranjangDetail.getQuantity(),updatedKeranjangDetail.getBarang().getHarga());
                    Float beratTemp = this.calcWeight(keranjangDetail.getQuantity(),updatedKeranjangDetail.getBarang().getBerat());

                    keranjangDetail.setBeratByQuantity(beratTemp);
                    updatedKeranjangDetail.setAmountByQuantity(temp);
                    return dozerBeanMapper.map(keranjangDetailRepository.save(updatedKeranjangDetail),KeranjangDetailDto.class);
                }

                else
                {
                    throw new EntityNotFoundException();
                }
            }
        return null;
    }

    public void deleteKeranjangDetailByBarangId(Integer idKeranjang, Integer idBarang)
    {
        Optional<KeranjangDetail> existingDetail =
                Optional.of(keranjangDetailRepository.findBykeranjang_idAndbarang_id(idKeranjang, idBarang));

        KeranjangDetail keranjangDetail = existingDetail.get();

        if(existingDetail.isPresent())
        {
            keranjangDetailRepository.deleteById(keranjangDetail.getId());
        }
        else
        {
            throw new EntityNotFoundException();
        }

    }

    public Double calcAmount(Integer quantity, Double harga){
        return quantity*harga;
    }

    public Float calcWeight(Integer quantity, Float berat){
        return quantity*berat;
    }

}
