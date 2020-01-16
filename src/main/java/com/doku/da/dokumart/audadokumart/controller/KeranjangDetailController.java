package com.doku.da.dokumart.audadokumart.controller;

import com.doku.da.dokumart.audadokumart.dto.BarangDto;
import com.doku.da.dokumart.audadokumart.dto.KeranjangDetailDto;
import com.doku.da.dokumart.audadokumart.dto.KeranjangDto;
import com.doku.da.dokumart.audadokumart.entity.Barang;
import com.doku.da.dokumart.audadokumart.entity.KeranjangDetail;
import com.doku.da.dokumart.audadokumart.service.KeranjangDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/keranjangdetails")
public class KeranjangDetailController {

    @Autowired
    private KeranjangDetailService keranjangDetailService;

    @GetMapping
    public ResponseEntity<List<KeranjangDetailDto>> all() {
        return ResponseEntity.ok(keranjangDetailService.getAllKeranjangDetail());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<KeranjangDetailDto> byId(@PathVariable Integer id){
        return ResponseEntity.ok(keranjangDetailService.getKeranjangDetailById(id));
    }

    @GetMapping(value = "keranjang/{id}")
    public ResponseEntity<List<KeranjangDetailDto>> byIdKeranjang(@PathVariable Integer id){
        return ResponseEntity.ok(keranjangDetailService.getAllKeranjangDetailByIdKeranjang(id));
    }

    @PostMapping
    public ResponseEntity<KeranjangDetailDto> post(@RequestBody final KeranjangDetail keranjangDetailFromRequest) {

        final URI uri =
                MvcUriComponentsBuilder
                        .fromController(getClass())
                        .path("/{id}")
                        .buildAndExpand(keranjangDetailFromRequest.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(keranjangDetailService.createKeranjangDetail(keranjangDetailFromRequest));
    }

    @PutMapping("/keranjang/{idKeranjang}/barang/{idbarang}")
    public ResponseEntity<KeranjangDetailDto> put(@RequestBody final KeranjangDetail keranjangDetailFromRequest, @PathVariable Integer idKeranjang, @PathVariable Integer idBarang) {
        return ResponseEntity.ok(keranjangDetailService.updateQuantityBarang(keranjangDetailFromRequest, idKeranjang, idBarang));
    }

}
