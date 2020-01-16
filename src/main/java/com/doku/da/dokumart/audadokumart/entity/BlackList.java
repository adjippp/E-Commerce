package com.doku.da.dokumart.audadokumart.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "master_blacklist")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BlackList extends RepresentationModel<BlackList> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String alasan;

    @OneToOne
    @JoinColumn(name = "id_pembeli")
    private Pembeli pembeli;

    //private int idPembeli;

}