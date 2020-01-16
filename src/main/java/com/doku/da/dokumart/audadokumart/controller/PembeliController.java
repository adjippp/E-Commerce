package com.doku.da.dokumart.audadokumart.controller;

import com.doku.da.dokumart.audadokumart.dto.KeranjangDto;
import com.doku.da.dokumart.audadokumart.dto.PembeliDto;
import com.doku.da.dokumart.audadokumart.dto.PenjualDto;
import com.doku.da.dokumart.audadokumart.entity.Pembeli;
import com.doku.da.dokumart.audadokumart.entity.Penjual;
import com.doku.da.dokumart.audadokumart.service.KeranjangService;
import com.doku.da.dokumart.audadokumart.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pembelis")
public class PembeliController {

    @Autowired
    private PembeliService pembeliService;

    @Autowired
    private KeranjangService keranjangService;

    @GetMapping
    public ResponseEntity<List<PembeliDto>> getAllPembeli() {
        return ResponseEntity.ok(pembeliService.getAllPembeli());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PembeliDto> byId(@PathVariable Integer id){
        return ResponseEntity.ok(pembeliService.getPembeliById(id));
    }

    @PostMapping
    public ResponseEntity<PembeliDto> createPembeli(@RequestBody final Pembeli pembeli) {
        final URI uri =
                MvcUriComponentsBuilder
                        .fromController(getClass())
                        .path("/{id}")
                        .buildAndExpand(pembeli.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(pembeliService.createPembeli(pembeli));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PembeliDto> updateSaldo(@RequestBody final Pembeli pembeli, @PathVariable Integer id) {
        return ResponseEntity.ok(pembeliService.updateNoHPPembeli(pembeli,id));
    }
    @GetMapping("/{id}/keranjangs")
    public ResponseEntity<KeranjangDto> getKeranjangByPembeliId(@PathVariable Integer id) {
        return ResponseEntity.ok(keranjangService.getAllIsiKeranjangByPembeliId(id));
    }
}
