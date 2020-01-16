package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.controller.BarangController;
import com.doku.da.dokumart.audadokumart.controller.PenjualController;
import com.doku.da.dokumart.audadokumart.entity.Kategori;
import com.doku.da.dokumart.audadokumart.entity.Penjual;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PenjualDto extends RepresentationModel {

    @Getter
    private Integer id;

    @Getter
    @Setter
    private String nama;

    @Getter
    @Setter
    private Double saldo;

    @Getter
    @Setter
    private String kota;

    private List<BarangDto> barangs;

    public void setId(Integer id) {
        this.id = id;
        add(linkTo(methodOn(PenjualController.class).getAllBarangByPenjualId(id)).withRel("barangs"));
        add(linkTo(methodOn(PenjualController.class).getById(id)).withSelfRel());
    }



}
