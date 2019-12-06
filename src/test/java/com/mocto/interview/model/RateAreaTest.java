package com.mocto.interview.model;

import org.junit.Assert;
import org.junit.Test;

public class RateAreaTest {

    @Test
    public void testConstructor() {
        String line = "36345,AL,01067,Henry,6";
        RateArea rateArea = new RateArea(line.split(","));
        Assert.assertEquals("AL", rateArea.getState());
        Assert.assertEquals(6, rateArea.getRateArea().intValue());
    }

    @Test
    public void testConstructor_SomeFieldsMissing() {
        String line = "36345,AL,,Henry,";
        RateArea zip = new RateArea(line.split(","));
        Assert.assertEquals("AL", zip.getState());
        Assert.assertNull(zip.getRateArea());
    }
}
