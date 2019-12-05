package com.mocto.interview.model;

import org.junit.Assert;
import org.junit.Test;

public class PlanTest {

    @Test
    public void testConstructor() {
        String line = "09846WB8636633,IL,Gold,361.69,5";
        Plan plan = new Plan(line.split(","));
        Assert.assertEquals("09846WB8636633", plan.getPlanId());
        Assert.assertEquals("IL", plan.getState());
        Assert.assertEquals(MetalLevel.Gold, plan.getMetalLevel());
        Assert.assertEquals(361.69, plan.getRate(), 0.01);
        Assert.assertEquals(5, plan.getRateArea().intValue());
    }

    @Test
    public void testConstructor_SomeFieldsMissing() {
        String line = "09846WB8636633,IL,,361.69,5";
        Plan plan = new Plan(line.split(","));
        Assert.assertEquals("09846WB8636633", plan.getPlanId());
        Assert.assertEquals("IL", plan.getState());
        Assert.assertNull(plan.getMetalLevel());
        Assert.assertEquals(361.69, plan.getRate(), 0.01);
        Assert.assertEquals(5, plan.getRateArea().intValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_LineIsEmpty() {
        new Plan(new String[0]);
    }
}
