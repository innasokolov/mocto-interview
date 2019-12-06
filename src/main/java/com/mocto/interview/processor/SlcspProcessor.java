package com.mocto.interview.processor;

import com.mocto.interview.model.Plan;
import com.mocto.interview.model.RateArea;
import com.mocto.interview.model.Slcsp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SlcspProcessor {

    private Map<RateArea, List<Plan>> plans;
    private Map<String, RateArea> zips;
    private List<Slcsp> slcsps;

    public List<Slcsp> process() {
        slcsps.stream().forEach(slcsp -> {
            List<Plan> rateAreaPlans = plans.get(zips.get(slcsp.getZipcode()));
            if (rateAreaPlans != null && rateAreaPlans.size() > 1) {
                Collections.sort(rateAreaPlans);
                slcsp.setRate(rateAreaPlans.get(1).getRate());
            }
        });
        return  slcsps;
    }
}
