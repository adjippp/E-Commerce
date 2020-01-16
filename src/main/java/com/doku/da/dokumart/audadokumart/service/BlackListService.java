package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.dto.BlacklistDto;
import com.doku.da.dokumart.audadokumart.dto.PostBlackListDto;
import com.doku.da.dokumart.audadokumart.entity.BlackList;
import com.doku.da.dokumart.audadokumart.entity.Pembeli;
import com.doku.da.dokumart.audadokumart.repository.BlackListRepository;
import com.doku.da.dokumart.audadokumart.common.exception.CustomException;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BlackListService {

    private BlackListRepository blackListRepository;

    private BlackList blackListModel = null;

    private PostBlackListDto postBlackListDto;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    @Autowired
    public BlackListService(BlackListRepository blackListRepository){
        this.blackListRepository = blackListRepository;
    }

    public CollectionModel<BlacklistDto> getAllAkun() {
        List<BlacklistDto> daftarBlacklist = blackListRepository.findAll().stream().map(BlacklistDto::new).collect(Collectors.toList());
        CollectionModel<BlacklistDto> collectionModel = new CollectionModel<>(daftarBlacklist);
        return collectionModel;
    }

    public PostBlackListDto getById(Integer id){
        postBlackListDto = blackListRepository.findById(id).map(PostBlackListDto::new).orElseThrow(() -> new CustomException(id,"Blacklist"));
        return postBlackListDto;
    }

    public BlackList getByIdPembeli(Integer id){
        blackListModel = blackListRepository.findByPembeli(id);
        return blackListModel;
    }

    public PostBlackListDto insertBlackList(PostBlackListDto postBlackListDto){
        BlackList blackList = dozerBeanMapper.map(postBlackListDto, BlackList.class);
        return new PostBlackListDto(blackListRepository.save(blackList));
    }

    public void deleteBlacklist(Integer id){
        if (blackListRepository.findById(id).isPresent()) {
            blackListRepository.deleteById(id);
        }else{
            throw new CustomException(id, "Blacklist");
        }
    }

}