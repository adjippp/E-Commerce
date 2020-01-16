package com.doku.da.dokumart.audadokumart.service;

import com.doku.da.dokumart.audadokumart.dto.BlacklistDto;
import com.doku.da.dokumart.audadokumart.dto.PostBlackListDto;
import com.doku.da.dokumart.audadokumart.entity.BlackList;
import com.doku.da.dokumart.audadokumart.entity.Pembeli;

import com.doku.da.dokumart.audadokumart.repository.BlackListRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.hateoas.CollectionModel;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BlackListServiceTest {

    @InjectMocks
    private BlackListService blackListService;

    @Mock
    private BlackListRepository blackListRepository;

    private BlackList blackList;

    private PostBlackListDto postBlackListDto;

    private Pembeli pembeli = new Pembeli();

    @Before
    public void init(){
        this.pembeli.setId(2);
        this.blackList = new BlackList(1, "Kriminal", this.pembeli);
        this.postBlackListDto = new PostBlackListDto(this.blackList);
        this.postBlackListDto.setPembeli(this.pembeli);
    }

    @Test
    public void getAll(){
        Pembeli pembeli1 = new Pembeli();
        pembeli1.setId(1);
        Pembeli pembeli2 = new Pembeli();
        pembeli2.setId(2);
        Pembeli pembeli3 = new Pembeli();
        pembeli3.setId(3);
        when(blackListRepository.findAll()).thenReturn(Arrays.asList(
                new BlackList(1, "Kriminal", pembeli1),
                new BlackList(2,"Sejarah Kelam", pembeli2),
                new BlackList(3, "Kecurangan", pembeli3)
        ));

        CollectionModel<BlacklistDto> daftarBlacklist = blackListService.getAllAkun();

        assertEquals(3, daftarBlacklist.getContent().size());
        assertEquals(1, daftarBlacklist.iterator().next().getId().intValue());
    }

    @Test
    public void getByIdTest(){
        when(blackListRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(this.blackList));

        postBlackListDto = blackListService.getById(1);

        assertEquals(1, postBlackListDto.getId().intValue());
        assertEquals("Kriminal", postBlackListDto.getAlasan());
        assertEquals(2, postBlackListDto.getIdPembeli().intValue());
    }

    @Test
    public void getByIdPembeli(){
        when(blackListRepository.findByPembeli(3)).thenReturn(this.blackList);

        blackList = blackListService.getByIdPembeli(3);

        assertEquals(1, blackList.getId().intValue());
        assertEquals("Kriminal", blackList.getAlasan());
        assertEquals(2, blackList.getPembeli().getId().intValue());
    }

    @Test
    @Ignore
    public void insertTest(){
        when(blackListRepository.save(this.blackList)).thenReturn(this.blackList);
        PostBlackListDto postBlackListDtoTest;
        postBlackListDtoTest = blackListService.insertBlackList(this.postBlackListDto);

        assertEquals(1, postBlackListDtoTest.getId().intValue());
        assertEquals("Kriminal", postBlackListDtoTest.getAlasan());
        assertEquals(2, postBlackListDtoTest.getIdPembeli().intValue());
    }


}
