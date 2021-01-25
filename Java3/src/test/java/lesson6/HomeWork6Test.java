package lesson6;

import org.junit.Assert;
import org.junit.Test;

public class HomeWork6Test {

    @Test
    public void test_check14() {

        Assert.assertTrue(HomeWork6.check14(new int[]{1, 2, 4, 3}));
        Assert.assertFalse(HomeWork6.check14(new int[]{6, 6, 7, 9}));
        Assert.assertFalse(HomeWork6.check14(new int[]{-2, 5, 7, 15, 19}));
        Assert.assertTrue(HomeWork6.check14(new int[]{6, 6, 7, 1}));

    }

    @Test
    public void test_getPart() {

        Assert.assertArrayEquals(new int[]{3}, HomeWork6.getPart(new int[]{1, 2, 4, 3}));
        Assert.assertArrayEquals(new int[]{5, 3, 8}, HomeWork6.getPart(new int[]{4, 5, 3, 8}));
        Assert.assertArrayEquals(new int[]{}, HomeWork6.getPart(new int[]{3, 8, 4}));
        Assert.assertArrayEquals(new int[]{}, HomeWork6.getPart(new int[]{3, 8, 4}));

    }

    @Test(expected = RuntimeException.class)
    public void test_getPart_exception() {

        Assert.assertArrayEquals(new int[]{3}, HomeWork6.getPart(new int[]{1, 2, 7, 3}));

    }

}
