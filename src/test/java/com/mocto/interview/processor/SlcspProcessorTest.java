package com.mocto.interview.processor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mocto.interview.model.MetalLevel;
import com.mocto.interview.model.Plan;
import com.mocto.interview.model.RateArea;
import com.mocto.interview.model.Slcsp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SlcspProcessorTest {
    private Map<RateArea, List<Plan>> plans;
    private Map<String, RateArea> zips;
    private List<Slcsp> slcsps;

    @Before
    public void setup() {
        List<Plan> planList = Lists.newArrayList(
        new Plan("28193UU0623361", MetalLevel.Silver, 227.52),
        new Plan("02127DK3707648", MetalLevel.Silver, 251.06),
        new Plan("00755MW8233171", MetalLevel.Silver, 212.35));
        RateArea rateArea = new RateArea("NY", 5);
        plans = Maps.newHashMap();
        plans.put(rateArea, planList);
        zips =  Maps.newHashMap();
        zips.put("11238", rateArea);
        slcsps = Lists.newArrayList(new Slcsp("11238", null));
    }

    @Test
    public void testProcess_Success() {
        SlcspProcessor processor = new SlcspProcessor(plans, zips, slcsps);
        List<Slcsp> result = processor.process();
        Assert.assertEquals(227.52, result.get(0).getRate(), 0.001);
    }

}
