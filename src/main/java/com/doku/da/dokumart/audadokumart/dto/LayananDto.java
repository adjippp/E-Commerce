package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.controller.LayananController;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class LayananDto extends RepresentationModel {

    @Getter
    private Integer id;

    @Getter
    @Setter
    private String nama, estimasi;

    @Getter
    @Setter
    private float beratMinimum, beratMaksimum;

    @Getter
    @Setter
    private double tarif;

    @Getter
    @Setter
    private EkspedisiDto ekspedisi;

    public void setId(Integer id) {
        this.id = id;
        add(linkTo(methodOn(LayananController.class).getById(id)).withSelfRel());
        add(linkTo(methodOn(LayananController.class).getEkspedisiByLayananId(id)).withRel("ekspedisi"));
    }

}
