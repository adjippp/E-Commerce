package com.doku.da.dokumart.audadokumart.entity;

import com.doku.da.dokumart.audadokumart.entity.payment.ListPaymentChannel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date trxDate;


    //    @ManyToMany(mappedBy = "transaksis")
    //    private List<Penjual> penjuals;
    //
    //    @ManyToOne(fetch = FetchType.LAZY)
    //    @JoinColumn(name = "id_pembeli" , nullable = false)
    //    private Pembeli pembeli;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "id_keranjang")
    private Keranjang keranjang;

    @Nullable
    @OneToOne(mappedBy = "transaksi")
    private APInvoice apInvoice;

    private Integer totalQty;
    private Double  totalAmt;
    private Float   totalBobot;

//    @OneToOne
//    @JoinColumn(name = "")
//    private PaymentPartner paymentPartner;
//    private Integer paymentPartnerFee;

//    private Integer id_ekspedisi;
//    private Integer ekspedisiFee;

}
