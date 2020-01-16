package com.doku.da.dokumart.audadokumart.dtoTest;

import com.doku.da.dokumart.audadokumart.dto.PostBlackListDto;
import com.doku.da.dokumart.audadokumart.entity.BlackList;
import com.doku.da.dokumart.audadokumart.entity.Pembeli;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PostBlackListDto.class)
public class PostBlackListDtoTest {

    private PostBlackListDto postBlackListDto;
    private BlackList blackList = new BlackList();
    private Pembeli pembeli = new Pembeli();
    private final String baseUrl = "http://localhost/";

    @Before
    public void init(){
        this.pembeli.setId(2);
        this.blackList = new BlackList(1, "Kriminal", this.pembeli);
        this.postBlackListDto = new PostBlackListDto(blackList);
    }

    @Test
    public void testId(){
        Assert.assertEquals(1, postBlackListDto.getId().intValue());
    }

    @Test
    public void testPembeli(){
        Assert.assertEquals(2, postBlackListDto.getIdPembeli().intValue());
    }

    @Test
    public void testAlasan(){
        Assert.assertEquals("Kriminal",postBlackListDto.getAlasan());
    }

    @Test
    public void testLinkSelf(){
         Link link = new Link(baseUrl+"blacklists/1");
         Assert.assertEquals(link.getHref(), postBlackListDto.getLinks().getRequiredLink("self").getHref());
    }

    @Test
    public void testLinkPembeli(){
         Link link = new Link(baseUrl+"pembelis/2");
         Assert.assertEquals(link.getHref(), postBlackListDto.getLinks().getRequiredLink("pembeli").getHref());
    }

}
