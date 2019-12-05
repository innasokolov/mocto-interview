package com.mocto.interview.processor;

import org.junit.Test;

public class SlcspProcessorTest {

    @Test(expected = UnsupportedOperationException.class)
    public void testProcess_Success() {
        SlcspProcessor processor = new SlcspProcessor();
        processor.process();
    }

}
