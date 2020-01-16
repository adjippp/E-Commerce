package com.doku.da.dokumart.audadokumart.Entity;

import com.doku.da.dokumart.audadokumart.entity.payment.ListPaymentChannel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ListPaymentChannel.class)
public class ListPaymentChannelTest {

    @Autowired
    ListPaymentChannel listPaymentChannel;

    @Test
    public void testListPaymentChannel(){
        listPaymentChannel = new ListPaymentChannel(4, "wallet", null);
        assertEquals(4, listPaymentChannel.getId().intValue());
        assertEquals("wallet", listPaymentChannel.getNama());
    }

    @Test
    public void testId(){
        listPaymentChannel.setId(1);
        assertEquals(1, listPaymentChannel.getId().intValue());
    }

    @Test
    public void testNama(){
        listPaymentChannel.setNama("payment");
        assertEquals("payment",listPaymentChannel.getNama());
    }

}
