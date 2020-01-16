package com.doku.da.dokumart.audadokumart.controller;

import com.doku.da.dokumart.audadokumart.dto.APInvoiceDto;
import com.doku.da.dokumart.audadokumart.dto.TransaksiDto;
import com.doku.da.dokumart.audadokumart.entity.APInvoice;
import com.doku.da.dokumart.audadokumart.entity.Transaksi;
import com.doku.da.dokumart.audadokumart.service.APInvoiceService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/ap")
public class APInvoiceController {

    @Autowired
    private APInvoiceService apInvoiceService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<APInvoiceDto>> getAll(){
        return ResponseEntity.ok(apInvoiceService.getAll());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<APInvoiceDto> getById(@PathVariable Integer Id) {
        return ResponseEntity.ok(apInvoiceService.getbyID(Id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<APInvoiceDto> create(@RequestBody APInvoiceDto apInvoiceDto) {
        return ResponseEntity.ok(apInvoiceService.create(apInvoiceDto));
    }
}
