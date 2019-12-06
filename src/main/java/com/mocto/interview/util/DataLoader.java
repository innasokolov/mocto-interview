package com.mocto.interview.util;

import com.mocto.interview.model.MetalLevel;
import com.mocto.interview.model.Plan;
import com.mocto.interview.model.RateArea;
import com.mocto.interview.model.Slcsp;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataLoader {
    public static Map<RateArea, List<Plan>> plans(MetalLevel metalLevel) throws IOException {
        CSVReader reader = reader("plans.csv");
        Map<RateArea, List<Plan>> plans = new HashMap<RateArea, List<Plan>>();
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            RateArea rateArea = new RateArea(nextLine);
            if (plans.get(rateArea) == null) {
                plans.put(new RateArea(nextLine), new ArrayList<>());
            }
            Plan plan = new Plan(nextLine);
            if (plan.getMetalLevel() != null && plan.getMetalLevel() == metalLevel) {
                if (!plans.get(rateArea).contains(plan)) {
                    plans.get(rateArea).add(plan);
                }
            }
        }
        return plans;
    }

    public static Map<String, RateArea> zips() throws IOException {
        CSVReader reader = reader("zips.csv");
        Map<String, RateArea> zips = new HashMap<String, RateArea>();
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            zips.put(nextLine[0], new RateArea(nextLine));
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

    private static CSVReader reader(String fileName) throws IOException {
        InputStream is = DataLoader.class.getClassLoader().getResourceAsStream(fileName);
        CSVReader reader = new CSVReader(new InputStreamReader(is));
        reader.skip(1);
        return reader;
    }
}
