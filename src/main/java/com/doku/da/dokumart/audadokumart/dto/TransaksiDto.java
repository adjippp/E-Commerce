package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.controller.APInvoiceController;
import com.doku.da.dokumart.audadokumart.controller.KeranjangController;
import com.doku.da.dokumart.audadokumart.controller.TransaksiController;
import com.doku.da.dokumart.audadokumart.entity.APInvoice;
import com.doku.da.dokumart.audadokumart.entity.BlackList;
import com.doku.da.dokumart.audadokumart.entity.Keranjang;
import com.doku.da.dokumart.audadokumart.entity.Transaksi;
import lombok.*;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class TransaksiDto extends RepresentationModel<TransaksiDto> {

    //private Transaksi transaksi;
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private Date trxDate;

    @Getter
    @Setter
    private KeranjangDto keranjangDto;

    @Getter
    @Setter
    private APInvoiceDto apInvoiceDto;

    @Getter
    @Setter
    private Integer totalQty;

    @Getter
    @Setter
    private Double  totalAmt;

    @Getter
    @Setter
    private Float   totalBobot;

//    public void setId(Integer id) {
//        this.id = id;
//        add(linkTo(methodOn(KeranjangController.class).byIdKeranjang(keranjangDto.getId())).withRel("Keranjang"));
//        add(linkTo(methodOn(APInvoiceController.class).getById(apInvoiceDto.getId())).withRel("AP Invoice"));
//    }

    //    public TransaksiDto(final Transaksi transaksi){
//        this.id = transaksi.getId();
//        this.trxDate = transaksi.getTrxDate();
//        this.keranjangDto = transaksi.getKeranjang();
//        this.apInvoiceDto = transaksi.getApInvoice();
//        this.totalQty    = transaksi.getTotalQty();
//        this.totalAmt    = transaksi.getTotalAmt();
//        this.totalBobot  = transaksi.getTotalBobot();
//        add(linkTo(methodOn(KeranjangController.class).byIdKeranjang(keranjangDto.getId())).withRel("Keranjang"));
//        add(linkTo(methodOn(APInvoiceController.class).getById(apInvoiceDto.getId())).withRel("AP Invoice"));
//    }

}
