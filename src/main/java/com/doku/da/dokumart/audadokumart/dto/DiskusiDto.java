package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.controller.DiskusiController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DiskusiDto extends RepresentationModel {

    @Getter
    private Integer id;

    @Getter
    @Setter
    private BarangDto barang;

    @Getter
    @Setter
    private PembeliDto pembeli;

    @Getter
    @Setter
    private String konten;

    @Getter
    @Setter
    private Integer tipe;

    @Nullable
    @Getter
    @Setter
    private Timestamp sentTime;

    public void setId(Integer id) {
        this.id = id;
        add(linkTo(methodOn(DiskusiController.class).byId(id)).withSelfRel());
        add(linkTo(methodOn(DiskusiController.class).getDiskusiByBarangId(barang.getId())).withRel("diskusi"));
    }

}
