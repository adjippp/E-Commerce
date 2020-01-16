package com.doku.da.dokumart.audadokumart.entity;

import javax.persistence.*;

@Entity
public class PaymentPartnerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPayment;

    @ManyToOne
    @JoinColumn(name="id_penjual")
    private Penjual penjual;

    public PaymentPartnerModel(Integer idPayment, Penjual penjual) {
        this.idPayment = idPayment;
        this.penjual = penjual;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public Penjual getPenjual() {
        return penjual;
    }

    public void setPenjual(Penjual penjual) {
        this.penjual = penjual;
    }
}
