package com.doku.da.dokumart.audadokumart.dto;

import com.doku.da.dokumart.audadokumart.controller.PaymentCore;
import com.doku.da.dokumart.audadokumart.entity.payment.Wallet;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Setter
@Getter
@NoArgsConstructor
public class WalletDto extends RepresentationModel {
    private Integer id;
    private String name;

    public WalletDto(Wallet wallet){
        this.id = wallet.getId();
        this.name = wallet.getName();
        add(linkTo(methodOn(PaymentCore.class).getByIdWallet(wallet.getId())).withSelfRel());
    }
}
