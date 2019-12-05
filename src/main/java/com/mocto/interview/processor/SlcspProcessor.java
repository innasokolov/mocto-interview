package com.mocto.interview.processor;

import com.mocto.interview.model.Plan;
import com.mocto.interview.model.Slcsp;
import com.mocto.interview.model.Zip;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SlcspProcessor {

    private List<Plan> plans;
    private List<Zip> zips;
    private List<Slcsp> slcsps;

    public List<Slcsp> process() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
