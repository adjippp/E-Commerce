package com.doku.da.dokumart.audadokumart.controller;

import com.doku.da.dokumart.audadokumart.dto.BlacklistDto;
import com.doku.da.dokumart.audadokumart.dto.PostBlackListDto;
import com.doku.da.dokumart.audadokumart.entity.BlackList;
import com.doku.da.dokumart.audadokumart.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/blacklists")
public class BlackListController {

    @Autowired
    private BlackListService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CollectionModel<BlacklistDto>> getAll(){
        return ResponseEntity.ok(service.getAllAkun());
    }

    @GetMapping("/{id}")
    public PostBlackListDto getById(@PathVariable Integer id){
       return service.getById(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE} )
    public PostBlackListDto insert(@RequestBody PostBlackListDto postBlackListDto){
        return service.insertBlackList(postBlackListDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        service.deleteBlacklist(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/pembeli/{id}")
    public BlackList getByIdPembeli(@PathVariable Integer id){
        return service.getByIdPembeli(id);
    }
}
