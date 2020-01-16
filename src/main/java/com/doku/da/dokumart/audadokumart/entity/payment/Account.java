package com.doku.da.dokumart.audadokumart.entity.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends RepresentationModel<Account> {

    @Id
    @NonNull
    private Integer id;

    @NonNull
    private String nama;

    @NumberFormat
    private Integer saldo;
}
