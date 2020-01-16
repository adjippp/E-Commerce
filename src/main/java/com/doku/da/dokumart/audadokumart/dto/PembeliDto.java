package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.controller.DiskusiController;
import com.doku.da.dokumart.audadokumart.controller.PembeliController;
import com.doku.da.dokumart.audadokumart.entity.Keranjang;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PembeliDto extends RepresentationModel {
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private Integer idWallet;

    @Getter
    @Setter
    private String nama;

    @Getter
    @Setter
    private String kota;

    @Getter
    @Setter
    private String noHP;

    @Getter
    @Setter
    private KeranjangDto keranjang;

    public void setId(Integer id) {
        this.id = id;
        add(linkTo(methodOn(PembeliController.class).byId(id)).withSelfRel());
        add(linkTo(methodOn(PembeliController.class).getKeranjangByPembeliId(id)).withRel("keranjang"));
    }
}
