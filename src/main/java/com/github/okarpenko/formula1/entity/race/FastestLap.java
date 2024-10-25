package com.github.okarpenko.formula1.entity.race;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FastestLap {

    private String time;

    @JsonProperty("driver")
    private DriverObj driver;

    @Data
    public static class DriverObj {
        @JsonProperty("id")
        private int driverId;
    }

}

