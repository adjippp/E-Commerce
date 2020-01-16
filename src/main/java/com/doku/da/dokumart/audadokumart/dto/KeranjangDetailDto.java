package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.controller.BarangController;
import com.doku.da.dokumart.audadokumart.controller.KeranjangController;
import com.doku.da.dokumart.audadokumart.controller.KeranjangDetailController;
import com.doku.da.dokumart.audadokumart.entity.Barang;
import com.doku.da.dokumart.audadokumart.entity.Keranjang;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class KeranjangDetailDto extends RepresentationModel {

    @Getter
    private Integer id;

    private KeranjangDto keranjang;

    @Getter
    @Setter
    private BarangDto barang;

    @Getter
    @Setter
    private Integer quantity;

    @Getter
    @Setter
    private Integer amountByQuantity;

    @Getter
    @Setter
    private Float beratByQuantity;

    public void setId(Integer id) {
        this.id = id;
        add(linkTo(methodOn(KeranjangDetailController.class).byId(id)).withSelfRel());
        add(linkTo(methodOn(BarangController.class).byId(barang.getId())).withRel("barang"));
    }
}