package com.doku.da.dokumart.audadokumart.dtoTest;

import com.doku.da.dokumart.audadokumart.constant.UrlSite;
import com.doku.da.dokumart.audadokumart.dto.ListPaymentChannelDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ListPaymentChannelDto.class)
public class ListPaymentChannelDtoTest {

    private ListPaymentChannelDto listPaymentChannelDto;
    private final String baseUrl = String.valueOf(UrlSite.BASE_URL);

    @Before
    public void init(){
        this.listPaymentChannelDto = new ListPaymentChannelDto(1, "wallet");
    }

    @Test
    public void testId(){
        listPaymentChannelDto.setId(1);
        assertEquals(1, listPaymentChannelDto.getId().intValue());
    }

    @Test
    public void testNama(){
        listPaymentChannelDto.setNama("wallet");
        assertEquals("wallet",listPaymentChannelDto.getNama());
    }

}
