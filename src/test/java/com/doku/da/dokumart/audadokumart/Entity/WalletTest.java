package com.doku.da.dokumart.audadokumart.Entity;

import com.doku.da.dokumart.audadokumart.entity.payment.Wallet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Wallet.class)
public class WalletTest {
    @Autowired
    private Wallet wallet;

    @Test
    public void testWallet(){
        wallet = new Wallet(1, "wallet");
        Assert.assertEquals(1, wallet.getId().intValue());
        Assert.assertEquals("wallet", wallet.getName());
    }

    @Test
    public void testId(){
        wallet.setId(2);
        Assert.assertEquals(2, wallet.getId().intValue());
    }

    @Test
    public void testNama(){
        wallet.setName("Namawallet");
        Assert.assertEquals("Namawallet", wallet.getName());
    }
}
