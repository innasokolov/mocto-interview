package com.mocto.interview.util;

import com.mocto.interview.model.Slcsp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataWriter {

    public static void write (List<Slcsp> slcsps, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);

        System.out.println("zipcode,rate");
        fileWriter.write("zipcode,rate\n");
        for (Slcsp slcsp : slcsps ) {
            System.out.println(slcsp.toString());
            fileWriter.write(slcsp.toString());
            fileWriter.write("\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
