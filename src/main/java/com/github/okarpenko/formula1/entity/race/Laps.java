package com.github.okarpenko.formula1.entity.race;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Laps {

    @JsonProperty("total")
    private int totalLaps;
}