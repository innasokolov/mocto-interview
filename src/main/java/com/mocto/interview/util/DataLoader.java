package com.mocto.interview.util;

import com.mocto.interview.model.Plan;
import com.mocto.interview.model.Slcsp;
import com.mocto.interview.model.Zip;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    public static List<Plan> plans() throws IOException {
        CSVReader reader = reader("plans.csv");
        List<Plan> plans = new ArrayList<Plan>();
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            plans.add(new Plan(nextLine));
        }
        return plans;
    }

    public static List<Zip> zips() throws IOException {
        CSVReader reader = reader("zips.csv");
        List<Zip> zips = new ArrayList<Zip>();
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            zips.add(new Zip(nextLine));
        }
        return zips;
    }

    public static List<Slcsp> slcsps() throws IOException {
        CSVReader reader = reader("slcsp.csv");
        List<Slcsp> slcsps = new ArrayList<Slcsp>();
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            slcsps.add(new Slcsp(nextLine));
        }
        return slcsps;
    }

    private static CSVReader reader(String fileName) {
        InputStream is = DataLoader.class.getClassLoader().getResourceAsStream(fileName);
        return new CSVReader(new InputStreamReader(is));
    }
}
