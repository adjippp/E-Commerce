package com.doku.da.dokumart.audadokumart.dtoTest;

import com.doku.da.dokumart.audadokumart.constant.UrlSite;
import com.doku.da.dokumart.audadokumart.dto.BlacklistDto;
import com.doku.da.dokumart.audadokumart.entity.BlackList;
import com.doku.da.dokumart.audadokumart.entity.Pembeli;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlacklistDto.class)
public class BlackListDtoTest {

    private BlacklistDto blacklistDto;
    private BlackList blackList = new BlackList();
    private Pembeli pembeli = new Pembeli();
    private final String baseUrl = UrlSite.BASE_URL.getUrl();

    @Before
    public void initDto(){
        this.pembeli.setId(2);
        this.blackList = new BlackList(1, "Kriminal", this.pembeli);
        this.blacklistDto = new BlacklistDto(blackList);
    }

    @Test
    public void testId(){
        assertEquals(1, blacklistDto.getId().intValue());
    }

    @Test
    public void testLinkSelf(){
         Link link = new Link(baseUrl+"blacklists/1");
        assertEquals(link.getHref(),blacklistDto.getLinks().getRequiredLink("self").getHref());
    }

    @Test
    public void testLinkPembeli(){
         Link link = new Link(baseUrl+"pembelis/2");
        assertEquals(link.getHref(),blacklistDto.getLinks().getRequiredLink("Pembeli").getHref());
    }

}
