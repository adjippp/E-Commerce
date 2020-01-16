package com.doku.da.dokumart.audadokumart.controller;

import com.doku.da.dokumart.audadokumart.dto.DiskusiDto;
import com.doku.da.dokumart.audadokumart.entity.Diskusi;
import com.doku.da.dokumart.audadokumart.entity.DiskusiJawab;
import com.doku.da.dokumart.audadokumart.entity.DiskusiTanya;
import com.doku.da.dokumart.audadokumart.service.DiskusiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/diskusis")
public class DiskusiController {

    @Autowired
    private DiskusiService diskusiService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DiskusiDto> byId (@PathVariable Integer id){
        return ResponseEntity.ok(diskusiService.getDiskusiById(id));
    }


    @GetMapping(value = "/barang/{id}")
    public ResponseEntity<List<DiskusiDto>> getDiskusiByBarangId(@PathVariable Integer id){
        return ResponseEntity.ok(diskusiService.getDiskusiByBarangId(id));
    }

    @PostMapping(value = "/pertanyaan")
    public ResponseEntity<DiskusiDto> postTanya(@RequestBody final Diskusi diskusiFromRequest) {
        final URI uri =
                MvcUriComponentsBuilder
                        .fromController(getClass())
                        .path("/{id}")
                        .buildAndExpand(diskusiFromRequest.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(diskusiService.createDiskusiTanya(diskusiFromRequest));
    }

    @PostMapping(value = "/jawaban")
    public ResponseEntity<DiskusiDto> postJawab(@RequestBody final Diskusi diskusiFromRequest) {
        final URI uri =
                MvcUriComponentsBuilder
                        .fromController(getClass())
                        .path("/{id}")
                        .buildAndExpand(diskusiFromRequest.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(diskusiService.createDiskusiJawab(diskusiFromRequest));
    }


}
