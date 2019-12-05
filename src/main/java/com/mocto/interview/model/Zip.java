package com.mocto.interview.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Zip {
    private String zipcode;
    private String state;
    private String countyCode;
    private String name;
    private int rateArea;
    public Zip(String [] fields) {
        if (fields == null || fields.length == 0) {
            throw new IllegalArgumentException("Zip fields are empty");
        }
        zipcode = fields[0];
        if (fields.length > 1) {
            state = fields[1];
        }
        if (fields.length > 2) {
            countyCode = fields[2];
        }
        if (fields.length > 3) {
            name = fields[3];
        }
        if (fields.length > 4) {
            rateArea = Integer.parseInt(fields[4]);
        }
    }
}
