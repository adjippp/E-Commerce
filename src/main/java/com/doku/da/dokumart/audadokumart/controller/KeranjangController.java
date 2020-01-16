package com.doku.da.dokumart.audadokumart.controller;

import com.doku.da.dokumart.audadokumart.dto.DiskusiDto;
import com.doku.da.dokumart.audadokumart.dto.KeranjangDetailDto;
import com.doku.da.dokumart.audadokumart.dto.KeranjangDto;
import com.doku.da.dokumart.audadokumart.dto.PembeliDto;
import com.doku.da.dokumart.audadokumart.entity.Keranjang;
import com.doku.da.dokumart.audadokumart.entity.KeranjangDetail;
import com.doku.da.dokumart.audadokumart.service.KeranjangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/keranjangs")
public class KeranjangController {

    @Autowired
    private KeranjangService keranjangService;

    @GetMapping
    public ResponseEntity<List<KeranjangDto>> getAllKeranjang() {
        return ResponseEntity.ok(keranjangService.getAllKeranjang());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<KeranjangDto> byIdKeranjang(@PathVariable Integer id){
        return ResponseEntity.ok(keranjangService.getKeranjangById(id));
    }

    @PostMapping
    public ResponseEntity<KeranjangDto> post(@RequestBody final Keranjang keranjang) {

        final URI uri =
                MvcUriComponentsBuilder
                        .fromController(getClass())
                        .path("/{id}")
                        .buildAndExpand(keranjang.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(keranjangService.createKeranjang(keranjang));
    }

}
