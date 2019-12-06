package com.mocto.interview.model;


import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"metalLevel", "rate"})
public class Plan implements Comparable {
    private String planId;
    private MetalLevel metalLevel;
    private Double rate;
    public Plan(String [] fields) {
        planId = fields[0];
        if (fields.length > 2) {
            try {
                metalLevel = MetalLevel.valueOf(fields[2]);
            } catch (Exception e) {
                //ignore
            }
        }
        if (fields.length > 3) {
            rate = Double.valueOf(fields[3]);
        }
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Plan)) {
            throw new IllegalArgumentException("Unable to compare, not a Plan: " + o.getClass());
        }
        int compare = this.getMetalLevel().compareTo(((Plan) o).getMetalLevel());
        if (compare == 0) {
            return this.getRate().compareTo(((Plan) o).getRate());
        } else {
            return compare;
        }
    }
}