package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.controller.BatchController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BatchDto extends RepresentationModel {
    @Getter
    private Integer id;

    @Getter
    @Setter
    private Integer batasKirim;

    @Getter
    @Setter
    private Time waktuMulai;

    @Getter
    @Setter
    private Time waktuSelesai;

    private List<APInvoiceDto> apInvoiceDtos;

    public void setId(Integer id){
        this.id = id;
        add(linkTo(methodOn(BatchController.class).getById(id)).withSelfRel());
    }
}
