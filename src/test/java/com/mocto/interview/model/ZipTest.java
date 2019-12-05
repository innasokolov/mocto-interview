package com.mocto.interview.model;

import org.junit.Assert;
import org.junit.Test;

public class ZipTest {

    @Test
    public void testConstructor() {
        String line = "36345,AL,01067,Henry,6";
        Zip zip = new Zip(line.split(","));
        Assert.assertEquals("36345", zip.getZipcode());
        Assert.assertEquals("AL", zip.getState());
        Assert.assertEquals("01067", zip.getCountyCode());
        Assert.assertEquals("Henry", zip.getName());
        Assert.assertEquals(6, zip.getRateArea());
    }

    @Test
    public void testConstructor_SomeFieldsMissing() {
        String line = "36345,AL,,Henry,6";
        Zip zip = new Zip(line.split(","));
        Assert.assertEquals("36345", zip.getZipcode());
        Assert.assertEquals("AL", zip.getState());
        Assert.assertEquals("", zip.getCountyCode());
        Assert.assertEquals("Henry", zip.getName());
        Assert.assertEquals(6, zip.getRateArea());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_LineIsEmpty() {
        new Zip(new String[0]);
    }
}
