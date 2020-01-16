package com.doku.da.dokumart.audadokumart.controller;

import com.doku.da.dokumart.audadokumart.dto.PenjualDto;
import com.doku.da.dokumart.audadokumart.entity.Barang;
import com.doku.da.dokumart.audadokumart.repository.BarangRepository;
import com.doku.da.dokumart.audadokumart.dto.BarangDto;
import com.doku.da.dokumart.audadokumart.service.BarangService;
import com.doku.da.dokumart.audadokumart.service.PenjualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/barangs")
public class BarangController {

    @Autowired
    private BarangService barangService;

    @Autowired
    private PenjualService penjualService;

    @GetMapping
    public ResponseEntity<List<BarangDto>> all() {
        return ResponseEntity.ok(barangService.getAllBarang());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BarangDto> byId(@PathVariable Integer id){
        return ResponseEntity.ok(barangService.getBarangById(id));
    }

    @PostMapping
    public ResponseEntity<BarangDto> post(@RequestBody final BarangDto barangFromRequest) {

        final URI uri =
                MvcUriComponentsBuilder
                        .fromController(getClass())
                        .path("/{id}")
                        .buildAndExpand(barangFromRequest.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(barangService.createBarang(barangFromRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarangDto> put(@RequestBody final BarangDto barangFromRequest, @PathVariable Integer id) {
        return ResponseEntity.ok(barangService.updateBarang(barangFromRequest, id));
    }


    @GetMapping("/{id}/penjual")
    public ResponseEntity<PenjualDto> getPenjualByBarangId(@PathVariable Integer id) {
        return ResponseEntity.ok(penjualService.getPenjualByBarangId(id));
    }

    @GetMapping("/kategori/{id}")
    public ResponseEntity<List<BarangDto>> getBarangByKategoriId(@PathVariable Integer id) {
        return ResponseEntity.ok(barangService.getAllBarangByKategoriId(id));
    }

    @GetMapping("penjual/{idPenjual}/kategori/{idKategori}")
    public ResponseEntity<List<BarangDto>> getBarangByPenjualIdAndKategoriId(@PathVariable Integer idPenjual, @PathVariable Integer idKategori) {
        return ResponseEntity.ok(barangService.getAllBarangByPenjualIdByKategori(idPenjual, idKategori ));
    }

    @GetMapping(value = "/kategori/{idKategori}/total", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Integer getBarangByPenjualIdAndKategoriId(@PathVariable Integer idKategori) {
        return barangService.getTotalBarangByKategori(idKategori);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBarangById(@PathVariable Integer id)
    {
        barangService.deleteBarangById(id);
        return ResponseEntity.noContent().build();
    }
}
