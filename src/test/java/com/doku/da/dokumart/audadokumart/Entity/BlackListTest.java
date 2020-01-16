package com.doku.da.dokumart.audadokumart.Entity;

import com.doku.da.dokumart.audadokumart.entity.BlackList;
import com.doku.da.dokumart.audadokumart.entity.Pembeli;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlackList.class)
public class BlackListTest {

    @Autowired
    private BlackList blacklistModel;

    private Pembeli pembeli = new Pembeli();
    private Integer idBlacklist = 1;
    private Integer idPembeli = 2;

    @Test
    public void testBlackListModel() {
        this.pembeli.setId(2);
        this.blacklistModel = new BlackList(1, "Kriminal", this.pembeli);
        assertEquals(this.idBlacklist, blacklistModel.getId());
        assertEquals(2, blacklistModel.getPembeli().getId().intValue());
        assertEquals("Kriminal", blacklistModel.getAlasan());
    }

    @Test
    public void testAkun() {
        this.pembeli.setId(2);
        blacklistModel.setPembeli(pembeli);
        assertEquals(this.idPembeli, blacklistModel.getPembeli().getId());
    }

    @Test
    public void testId() {
        blacklistModel.setId(3);
        assertEquals(3, blacklistModel.getId().intValue());
    }

    @Test
    public void testAlasan(){
        blacklistModel.setAlasan("kriminal");
        assertEquals("kriminal", blacklistModel.getAlasan());
    }
}