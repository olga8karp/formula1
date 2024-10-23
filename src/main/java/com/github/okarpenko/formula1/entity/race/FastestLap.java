package com.github.okarpenko.formula1.entity.race;

import java.time.Duration;
import lombok.Data;

@Data
public class FastestLap {

    private Duration duration;
    private int driverId;
}
