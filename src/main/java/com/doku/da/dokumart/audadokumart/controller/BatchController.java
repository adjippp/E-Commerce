package com.doku.da.dokumart.audadokumart.controller;

import com.doku.da.dokumart.audadokumart.dto.BatchDto;
import com.doku.da.dokumart.audadokumart.dto.ResponseResi;
import com.doku.da.dokumart.audadokumart.dto.TransaksiDto;
import com.doku.da.dokumart.audadokumart.entity.Batch;
import com.doku.da.dokumart.audadokumart.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/batchs")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BatchDto> getAll() {
        return  batchService.getAllBatch();
    }

    @GetMapping("/{id}")
    public BatchDto getById(@PathVariable Integer id) {
        return batchService.getBatchById(id);
    }

    @PostMapping
    public ResponseEntity<BatchDto> insert(@RequestBody final Batch batch) {
        final URI uri = MvcUriComponentsBuilder
                .fromController(getClass())
                .path("/{id}")
                .buildAndExpand(batch.getIdBatch())
                .toUri();
        return ResponseEntity.created(uri).body(batchService.createBatch(batch));
    }

    @GetMapping(value = "/transaksi/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseResi kirimBarang(@PathVariable Integer id) {
        return batchService.KirimBarang(id);
    }
}
