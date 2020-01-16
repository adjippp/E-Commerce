package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.controller.BlackListController;
import com.doku.da.dokumart.audadokumart.controller.PembeliController;
import com.doku.da.dokumart.audadokumart.entity.BlackList;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Data
@NoArgsConstructor
public class BlacklistDto  extends RepresentationModel {

    private Integer id;

    public BlacklistDto(final BlackList blackList){
         this.id = blackList.getId();
         Integer idBlacklist = blackList.getId();
         Integer idPembeli = blackList.getPembeli().getId();
         add(linkTo(methodOn(BlackListController.class).getById(idBlacklist)).withSelfRel());
         add(linkTo(methodOn(PembeliController.class).byId(idPembeli)).withRel("Pembeli"));
    }
}
