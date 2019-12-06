package com.mocto.interview.model;


import lombok.*;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Slcsp {
    private String zipcode;
    private Double rate;
    public Slcsp(String [] fields) {
        zipcode = fields[0];
        if (fields.length > 1 && StringUtils.isNotBlank(fields[1])) {
            rate = Double.valueOf(fields[1]);
        }
    }

    @Override
    public String toString() {
        return this.getZipcode() + "," + ((this.getRate() != null)?this.getRate():"");
    }
}
