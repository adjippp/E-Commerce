package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.controller.KeranjangController;
import com.doku.da.dokumart.audadokumart.controller.KeranjangDetailController;
import com.doku.da.dokumart.audadokumart.controller.PembeliController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class KeranjangDto extends RepresentationModel {
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private List<KeranjangDetailDto> keranjangDetail;

//    @Getter
//    @Setter
//    private Double amountByQuantity;

    public void setId(Integer id) {
        this.id = id;
        add(linkTo(methodOn(KeranjangController.class).byIdKeranjang(id)).withSelfRel());
        add(linkTo(methodOn(KeranjangDetailController.class).byIdKeranjang(id)).withRel("keranjangdetails"));
    }
}
