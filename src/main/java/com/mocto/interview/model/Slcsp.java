package com.mocto.interview.model;


import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Slcsp {
    private String zipcode;
    private Double rate;
    public Slcsp(String [] fields) {
        if (fields == null || fields.length == 0) {
            throw new IllegalArgumentException("Slcsp fields are empty");
        }
        zipcode = fields[0];
        if (fields.length > 1) {
            rate = Double.valueOf(fields[1]);
        }

    }
}
