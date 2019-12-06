package com.mocto.interview.model;

import org.junit.Assert;
import org.junit.Test;

public class SlcspTest {

    @Test
    public void testConstructor() {
        String line = "64148,";
        Slcsp slcsp = new Slcsp(line.split(","));
        Assert.assertNull(slcsp.getRate());
    }
}
