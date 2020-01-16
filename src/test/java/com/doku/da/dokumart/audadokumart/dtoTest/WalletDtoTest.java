package com.doku.da.dokumart.audadokumart.dtoTest;

import com.doku.da.dokumart.audadokumart.constant.UrlSite;
import com.doku.da.dokumart.audadokumart.dto.WalletDto;
import com.doku.da.dokumart.audadokumart.entity.payment.Wallet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Link;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WalletDto.class)
public class WalletDtoTest {

    private WalletDto walletDto;

    private Wallet wallet = new Wallet();

    private final String baseUrl = UrlSite.BASE_URL.getUrl();

    @Before
    public void initDto(){
        this.wallet = new Wallet(1,"namaWallet");
        this.walletDto = new WalletDto(this.wallet);
    }

    @Test
    public void testWalletDto(){
        walletDto = new WalletDto(this.wallet);
        Link link = new Link(baseUrl+"paymentchannels/Wallets/1");
        Assert.assertEquals(1, walletDto.getId().intValue());
        Assert.assertEquals("namaWallet", walletDto.getName());
        Assert.assertEquals(link.getHref(), walletDto.getRequiredLink("self").getHref());
    }

    @Test
    public void testId(){
        walletDto.setId(10);
        Assert.assertEquals(10, walletDto.getId().intValue());
    }

    @Test
    public void testNama(){
        walletDto.setName("wallet");
        Assert.assertEquals("wallet",walletDto.getName());
    }



}
