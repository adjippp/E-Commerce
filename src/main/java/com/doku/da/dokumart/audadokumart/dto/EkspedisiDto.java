package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.controller.EkspedisiController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EkspedisiDto extends RepresentationModel{
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
    private PenjualDto penjual;

    @Getter
    @Setter
    private List<LayananDto> layanans;

    public void setId(Integer id){
        this.id = id;
        add(linkTo(methodOn(EkspedisiController.class).getById(id)).withSelfRel());
        add(linkTo(methodOn(EkspedisiController.class).getLayananByEkspedisiId(id)).withRel("layanan"));
    }
}
