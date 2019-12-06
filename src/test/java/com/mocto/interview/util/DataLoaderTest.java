package com.mocto.interview.util;

import com.mocto.interview.model.MetalLevel;
import com.mocto.interview.model.Plan;
import com.mocto.interview.model.RateArea;
import com.mocto.interview.model.Slcsp;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class DataLoaderTest {

    @Test
    public void testPlans() throws Exception {
        Map<RateArea, List<Plan>> plans = DataLoader.plans(MetalLevel.Silver);
        Assert.assertEquals(1, plans.size());
        RateArea rateArea = new RateArea("KS", 6);
        Assert.assertEquals(1, plans.size());
        Assert.assertEquals(12, plans.get(rateArea).size());
        Assert.assertEquals("24136DT6341333", plans.get(rateArea).get(0).getPlanId());
    }

    @Test
    public void testZips() throws Exception {
        Map<String, RateArea> zips = DataLoader.zips();
        Assert.assertEquals(42, zips.size());
        RateArea rateArea = new RateArea("KS", 6);
        Assert.assertEquals(rateArea, zips.get("67344"));
    }

    @Test
    public void testSlcsp() throws Exception {
        List<Slcsp> slcsps = DataLoader.slcsps();
        Assert.assertEquals(3, slcsps.size());
        slcsps.forEach(slcsp -> {
            Assert.assertNull(slcsp.getRate());
        });
    }
}
