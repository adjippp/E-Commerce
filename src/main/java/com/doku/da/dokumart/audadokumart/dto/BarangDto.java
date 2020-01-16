package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.controller.BarangController;
import com.doku.da.dokumart.audadokumart.controller.DiskusiController;
import com.doku.da.dokumart.audadokumart.entity.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BarangDto extends RepresentationModel {

    @Getter
    private Integer id;

    @Getter
    @Setter
    private String nama;

    @Getter
    @Setter
    private Double harga;

    @Getter
    @Setter
    private Kategori kategori;

    @Getter
    @Setter
    private Integer stok;

    @Getter
    @Setter
    private Float berat;

    @Getter
    @Setter
    private PenjualDto penjual;

    private List<KeranjangDetailDto> keranjangs;

    @Getter
    @Setter
    private List<DiskusiDto> chatRooms;


    public void setId(Integer id) {
        this.id = id;
//        add(linkTo(BarangController.class).withRel("barang"));
        add(linkTo(methodOn(BarangController.class).byId(id)).withSelfRel());
        add(linkTo(methodOn(BarangController.class).getPenjualByBarangId(id)).withRel("penjual"));
        add(linkTo(methodOn(BarangController.class).getBarangByKategoriId(id)).withRel("kategori"));
        add(linkTo(methodOn(BarangController.class).getBarangByPenjualIdAndKategoriId(id,kategori.getId())).withRel("kategori by penjual"));
        add(linkTo(methodOn(DiskusiController.class).getDiskusiByBarangId(id)).withRel("Diskusi"));
    }

    public BarangDto() {
    }
}
