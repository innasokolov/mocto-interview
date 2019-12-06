package com.mocto.interview.model;


import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"state", "rateArea"})
public class RateArea {
    private String state;
    private Integer rateArea;

    public RateArea(String [] fields) {
        if (fields.length > 1) {
            state = fields[1];
        }
        if (fields.length > 4) {
            rateArea = Integer.valueOf(fields[4]);
        }
    }
}