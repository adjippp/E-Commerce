package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.controller.BlackListController;
import com.doku.da.dokumart.audadokumart.controller.PembeliController;
import com.doku.da.dokumart.audadokumart.entity.BlackList;
import com.doku.da.dokumart.audadokumart.entity.Pembeli;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostBlackListDto extends RepresentationModel {
    private Integer id;
    private String alasan;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Pembeli pembeli;

    private Integer idPembeli;

    public PostBlackListDto(BlackList blackList){
        this.id = blackList.getId();
        this.idPembeli = blackList.getPembeli().getId();
        this.alasan = blackList.getAlasan();
        Integer idBlacklist = blackList.getId();
        Integer idPembeli = blackList.getPembeli().getId();
        add(linkTo(methodOn(BlackListController.class).getById(idBlacklist)).withSelfRel());
        add(linkTo(methodOn(PembeliController.class).byId(idPembeli)).withRel("Pembeli"));
    }
}
