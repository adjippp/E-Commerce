package com.doku.da.dokumart.audadokumart.entity;

import com.doku.da.dokumart.audadokumart.entity.payment.ListPaymentChannel;
import com.doku.da.dokumart.audadokumart.interfaces.Client;
import com.doku.da.dokumart.audadokumart.interfaces.Invoice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import sun.security.util.Pem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APInvoice {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private Date dateAP;

        @OneToOne
        @JoinColumn(name = "id_transaksi")
        private Transaksi transaksi;

        @ManyToOne
        @JoinColumn(name = "id_ekspedisi")
        private Ekspedisi ekspedisi;

        private Double ekspedisiFee;

        @ManyToOne
        @JoinColumn(name = "id_listPaymentChannel")
        private ListPaymentChannel listPaymentChannel;

        private Double paymentChannelFee;

        @ManyToOne
        @JoinColumn(name = "id_penjual")
        private Penjual penjual;

        private Double totalAmtJual;

        @ManyToOne
        @JoinColumn(name = "id_batch")
        private Batch batch;

}