package com.mocto.interview.model;


import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plan {
    private String planId;
    private String state;
    private MetalLevel metalLevel;
    private Float rate;
    private Integer rateArea;
    public Plan(String [] fields) {
        if (fields == null || fields.length == 0) {
            throw new IllegalArgumentException("Plan fields are empty");
        }
        planId = fields[0];
        if (fields.length > 1) {
            state = fields[1];
        }
        if (fields.length > 2) {
            try {
                metalLevel = MetalLevel.valueOf(fields[2]);
            } catch (Exception e) {
                //ignore
            }
        }
        if (fields.length > 3) {
            rate = Float.valueOf(fields[3]);
        }
        if (fields.length > 4) {
            rateArea = Integer.valueOf(fields[4]);
        }
    }
}