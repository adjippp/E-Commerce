package com.doku.da.dokumart.audadokumart.controller;

import com.doku.da.dokumart.audadokumart.dto.BarangDto;
import com.doku.da.dokumart.audadokumart.entity.Barang;
import com.doku.da.dokumart.audadokumart.entity.Penjual;
import com.doku.da.dokumart.audadokumart.dto.PenjualDto;
import com.doku.da.dokumart.audadokumart.service.BarangService;
import com.doku.da.dokumart.audadokumart.service.PenjualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/penjuals")
public class PenjualController {

    @Autowired
    private PenjualService penjualService;

    @Autowired
    private BarangService barangService;

    @GetMapping
    public ResponseEntity<CollectionModel<PenjualDto>> all() {
        ResponseEntity<CollectionModel<PenjualDto>> allPenjual = penjualService.getAllPenjual();
        return allPenjual;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PenjualDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(penjualService.getPenjualById(id));
    }


    @PostMapping
    public ResponseEntity<PenjualDto> create(@RequestBody final PenjualDto penjualFromRequest) {
        final URI uri =
                MvcUriComponentsBuilder
                        .fromController(getClass())
                        .path("/{id}")
                        .buildAndExpand(penjualFromRequest.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(penjualService.createPenjual(penjualFromRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PenjualDto> updateSaldo(@RequestBody final PenjualDto penjualFromRequest, @PathVariable Integer id) {
        return ResponseEntity.ok(penjualService.updateSaldoPenjual(penjualFromRequest, id));
    }

    @GetMapping("/{id}/barangs")
    public ResponseEntity<List<BarangDto>> getAllBarangByPenjualId(@PathVariable Integer id) {
        return ResponseEntity.ok(barangService.getAllBarangByPenjualId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePenjualById(@PathVariable Integer id)
    {
        penjualService.deletePenjualById(id);
        return ResponseEntity.noContent().build();
    }

}

