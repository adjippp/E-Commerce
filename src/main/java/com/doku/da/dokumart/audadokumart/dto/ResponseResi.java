package com.doku.da.dokumart.audadokumart.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class ResponseResi extends RepresentationModel {
    private Integer idTransaksi;
    private String resi;
    private String statusPengiriman;
}
