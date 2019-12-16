package com.doku.da.dokumart.audadokumart.controller;

import com.doku.da.dokumart.audadokumart.model.Barang;
import com.doku.da.dokumart.audadokumart.response.BaseResponse;
import com.doku.da.dokumart.audadokumart.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BarangController {

    BarangService barangService;

    @Autowired
    public BarangController(BarangService barangService) {
        this.barangService = barangService;
    }

    @GetMapping(value = "/barang/penjualId/{id}")
    @ResponseBody
    public List<Barang> getAllBarangByPenjual(@PathVariable Integer id)
    {
        return barangService.getBarangByPenjual(id);
    }

    @GetMapping(value = "/barang")
    @ResponseBody
    public List<Barang> getAllBarang()
    {
        return barangService.getAllBarang();
    }

    @PostMapping(value = "/barang/post")
    public Barang createRoom(@RequestBody Barang barang)
    {
        return barangService.create(barang);
    }

    @PutMapping(value = "/barang/{id}")
    public Barang updateBarang(@RequestBody Barang barang, @PathVariable Integer id)
    {
        return barangService.update(barang,id);
    }

    @DeleteMapping(value = "/delete/{id}")
    BaseResponse deleteBarang(@PathVariable Integer id)
    {
        return barangService.delete(id);
    }
}
