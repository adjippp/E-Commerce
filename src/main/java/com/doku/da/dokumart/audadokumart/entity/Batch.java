package com.doku.da.dokumart.audadokumart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "BATCH")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idBatch;
    private int batasKirim;
    private Time waktuMulai;
    private Time waktuSelesai;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "batch")
    private List<APInvoice> apInvoiceList;

    public Batch(int idBatch, int batasKirim, Time waktuMulai, Time waktuSelesai, List<APInvoice> apInvoiceList){
        this.idBatch = idBatch;
        this.batasKirim = batasKirim;
        this.waktuMulai = waktuMulai;
        this.waktuSelesai = waktuSelesai;
        this.apInvoiceList = apInvoiceList;
    }

    public int getIdBatch() {
        return idBatch;
    }

    public void setIdBatch(int idBatch) {
        this.idBatch = idBatch;
    }

    public int getBatasKirim() {
        return batasKirim;
    }

    public void setBatasKirim(int batasKirim) {
        this.batasKirim = batasKirim;
    }

    public Time getWaktuMulai() {
        return waktuMulai;
    }

    public void setWaktuMulai(Time waktuMulai) {
        this.waktuMulai = waktuMulai;
    }

    public Time getWaktuSelesai() {
        return waktuSelesai;
    }

    public void setWaktuSelesai(Time waktuSelesai) {
        this.waktuSelesai = waktuSelesai;
    }

    public List<APInvoice> getApInvoiceList() {
        return apInvoiceList;
    }

    public void setApInvoiceList(List<APInvoice> apInvoiceList) {
        this.apInvoiceList = apInvoiceList;
    }
}
