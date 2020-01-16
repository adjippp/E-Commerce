package com.doku.da.dokumart.audadokumart.controller;

import com.doku.da.dokumart.audadokumart.dto.EkspedisiDto;
import com.doku.da.dokumart.audadokumart.dto.LayananDto;
import com.doku.da.dokumart.audadokumart.entity.Ekspedisi;
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
@RequestMapping("/ekspedisis")
public class EkspedisiController {

    @Autowired
    private EkspedisiService ekspedisiService;

    @Autowired
    private LayananService layananService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EkspedisiDto> getAll() {
        return ekspedisiService.getAllEkspedisi();
    }

    @GetMapping(value = "/{id}")
    public EkspedisiDto getById(@PathVariable Integer id) {
        return ekspedisiService.getEkspedisiById(id);
    }

    //    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
//    public EkspedisiDto insert(@RequestBody EkspedisiDto ekspedisiDto){
//        return ekspedisiService.createEkspedisi(ekspedisiDto);
//    }
    @PostMapping
    public ResponseEntity<EkspedisiDto> insert(@RequestBody final Ekspedisi ekspedisi) {
        final URI uri = MvcUriComponentsBuilder
                .fromController(getClass())
                .path("/{id}")
                .buildAndExpand(ekspedisi.getId())
                .toUri();
        return ResponseEntity.created(uri).body(ekspedisiService.createEkspedisi(ekspedisi));
    }

    @GetMapping("/{id}/layanans")
    public List<LayananDto> getLayananByEkspedisiId(@PathVariable Integer id) {
        return layananService.getLayananByEkspedisiId(id);
    }

    @PutMapping("/{id}")
    public EkspedisiDto editEkspedisi(@RequestBody Ekspedisi ekspedisi, @PathVariable Integer id) {
        return ekspedisiService.updateEkspedisi(ekspedisi, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEkspedisi(@PathVariable Integer id) {
        ekspedisiService.deleteEkspedisi(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/tarif", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Double tarifKirim() {
        return ekspedisiService.hitungBiaya();
    }
}
