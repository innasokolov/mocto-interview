package com.mocto.interview.util;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.mocto.interview.model.RateArea;
import com.mocto.interview.model.Slcsp;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

public class DataWriterTest {

    private String fileName = "src/test/resources/slcsp_out.csv";


    @After
    public void teardown() {
        new File(fileName).deleteOnExit();
    }

    @Test
    public void test() throws Exception {
        List<Slcsp> slcsps = Lists.newArrayList(new Slcsp("11238", 234.55),
                new Slcsp("11217", 574.55));
        DataWriter.write(slcsps, fileName);

        List<String> lines = Files.readLines(new File(fileName), Charset.defaultCharset());
        RateArea rateArea = new RateArea("KS", 6);
        Assert.assertEquals("zipcode,rate", lines.get(0));
        Assert.assertEquals("11238,234.55", lines.get(1));
        Assert.assertEquals("11217,574.55", lines.get(2));
    }
}
