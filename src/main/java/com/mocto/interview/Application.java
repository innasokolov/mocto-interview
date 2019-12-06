package com.mocto.interview;


import com.mocto.interview.model.MetalLevel;
import com.mocto.interview.model.Slcsp;
import com.mocto.interview.processor.SlcspProcessor;
import com.mocto.interview.util.DataLoader;
import com.mocto.interview.util.DataWriter;

import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {
        SlcspProcessor slcspProcessor = new SlcspProcessor(DataLoader.plans(MetalLevel.Silver),
                DataLoader.zips(), DataLoader.slcsps());
        List<Slcsp> result = slcspProcessor.process();
        DataWriter.write(result, "src/main/resources/slcsp_out.csv");
    }
}
