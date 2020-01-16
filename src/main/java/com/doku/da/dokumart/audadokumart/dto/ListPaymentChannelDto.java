package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.controller.PaymentCore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListPaymentChannelDto  extends RepresentationModel {
    private Integer id;
    private String nama;

    public void setNama(String nama){
        this.nama = nama;
        add(linkTo(PaymentCore.class).slash(nama).withRel("Channel"));
    }
}
