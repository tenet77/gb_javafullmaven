package lesson4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XOTest {

    @Before
    public void init() {
        XO.fillMap(3, 3);
    }

    @Test
    public void testUser() {
        XO.move(0, 0, XO.USER);
        XO.move(1, 1, XO.USER);
        XO.move(2, 2, XO.USER);
        Assert.assertEquals(XO.isVictory(), XO.USER);
    }

    @Test
    public void testPC() {
        XO.move(0, 0, XO.PC);
        XO.move(1, 1, XO.PC);
        XO.move(2, 2, XO.PC);
        Assert.assertEquals(XO.isVictory(), XO.PC);
    }

}
