package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.dto.KeranjangDto;
import com.doku.da.dokumart.audadokumart.dto.TransaksiDto;
import com.doku.da.dokumart.audadokumart.entity.Barang;
import com.doku.da.dokumart.audadokumart.entity.Keranjang;
import com.doku.da.dokumart.audadokumart.entity.KeranjangDetail;
import com.doku.da.dokumart.audadokumart.entity.Transaksi;
import com.doku.da.dokumart.audadokumart.repository.TransaksiRepository;
import com.doku.da.dokumart.audadokumart.common.exception.CustomException;
import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
public class TransaksiService {
    @Autowired
    private TransaksiRepository transaksiRepository;

//    private Transaksi transaksiModel;

    private List<Transaksi> temptransaksi = new ArrayList<>();

    private ModelMapper modelMapper;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public List<TransaksiDto> getAllTrx() {
        final List<TransaksiDto> collection =
                transaksiRepository
                        .findAll()
                        .stream()
                        .map(transaksi -> dozerBeanMapper.map(transaksi, TransaksiDto.class))
                        .collect(Collectors.toList());
        return collection;
    }

        public TransaksiDto getTrxById(Integer Id){
        TransaksiDto transaksiDto =
                transaksiRepository
                    .findById(Id)
                    .map(transaksi -> dozerBeanMapper.map(transaksi, TransaksiDto.class))
                    .orElseThrow(() -> new CustomException(Id, "Transaksi"));
        return transaksiDto;
    }

    public TransaksiDto createTrx(TransaksiDto transaksiDtoInput){
        KeranjangDto keranjangDto = transaksiDtoInput.getKeranjangDto();
        Keranjang keranjangInput = dozerBeanMapper.map(keranjangDto, Keranjang.class);

        Transaksi transaksiInput = dozerBeanMapper.map(transaksiDtoInput, Transaksi.class);

        transaksiInput.setKeranjang(keranjangInput);

        final Integer totalQty = transaksiRepository.getTotalQty(transaksiInput.getKeranjang().getId());
        transaksiInput.setTotalQty(totalQty);

        final Double totalAmt = transaksiRepository.getTotalAmt(transaksiInput.getKeranjang().getId());
        transaksiInput.setTotalAmt(totalAmt);

        final Float totalBobot = transaksiRepository.getTotalBobot(transaksiInput.getKeranjang().getId());
        transaksiInput.setTotalBobot(totalBobot);

        final Transaksi save = transaksiRepository.save(transaksiInput);
        TransaksiDto transaksiDto = dozerBeanMapper.map(save, TransaksiDto.class);
        return transaksiDto;
    }

        public TransaksiDto getByAPInvoiceId(Integer id) {
        TransaksiDto transaksiDto = Optional.of(transaksiRepository.findByAPInvoice_Id(id))
                .map(transaksi -> dozerBeanMapper.map(transaksi, TransaksiDto.class))
                .orElseThrow(() -> new CustomException(id, "transaksi"));
        return transaksiDto;
    }

//    public List<Barang> getBarang(Transaksi transaksiInput){
//        List<Barang> barangList = new ArrayList<>();
//        barangList = transaksiInput.getKeranjang().getBarang();
//        return barangList;
//    }
}
