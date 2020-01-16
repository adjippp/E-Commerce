package com.doku.da.dokumart.audadokumart.controller;

import com.doku.da.dokumart.audadokumart.dto.TransaksiDto;
import com.doku.da.dokumart.audadokumart.entity.Transaksi;
import com.doku.da.dokumart.audadokumart.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaksi")
public class TransaksiController {

    @Autowired
    private TransaksiService transaksiService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TransaksiDto>> getAll(){
        return ResponseEntity.ok(transaksiService.getAllTrx());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<TransaksiDto> getById(@PathVariable Integer Id) {
        return ResponseEntity.ok(transaksiService.getTrxById(Id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransaksiDto> create(@RequestBody TransaksiDto transaksiDto) {
        return ResponseEntity.ok(transaksiService.createTrx(transaksiDto));
    }

    @GetMapping("/ap/{id}")
    public TransaksiDto getByAPInvoiceID(@PathVariable Integer Id){
        return transaksiService.getByAPInvoiceId(Id);
    }

}
