package com.doku.da.dokumart.audadokumart.controller;

import com.doku.da.dokumart.audadokumart.dto.EkspedisiDto;
import com.doku.da.dokumart.audadokumart.dto.LayananDto;
import com.doku.da.dokumart.audadokumart.entity.Layanan;
import com.doku.da.dokumart.audadokumart.service.EkspedisiService;
import com.doku.da.dokumart.audadokumart.service.LayananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/layanans")
public class LayananController {

    @Autowired
    private LayananService layananService;

    @Autowired
    private EkspedisiService ekspedisiService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LayananDto> getAll() {
        return layananService.getAllLayanan();
    }

    @GetMapping(value = "/{id}")
    public LayananDto getById(@PathVariable Integer id){
        return layananService.getLayananById(id);
    }

    @PostMapping
    public ResponseEntity<LayananDto> insert(@RequestBody final Layanan layanan) {
        final URI uri = MvcUriComponentsBuilder
                .fromController(getClass())
                .path("/{id}")
                .buildAndExpand(layanan.getId())
                .toUri();
        return ResponseEntity.created(uri).body(layananService.createLayanan(layanan));

    }

    @GetMapping("/{id}/ekspedisi")
    public EkspedisiDto getEkspedisiByLayananId(@PathVariable Integer id) {
        return ekspedisiService.getEkspedisiByLayananId(id);
    }

    @PutMapping("/{id}")
    public LayananDto editLayanan(@RequestBody Layanan layanan, @PathVariable Integer id) {
        return layananService.updateLayanan(layanan, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLayanan(@PathVariable Integer id) {
        layananService.deleteLayanan(id);
        return ResponseEntity.noContent().build();
    }

}
