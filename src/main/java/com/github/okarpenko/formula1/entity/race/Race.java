package com.github.okarpenko.formula1.entity.race;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.okarpenko.formula1.entity.Circuit;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Race {

    private int id;

    private Competition competition;
    private Circuit circuit;
    private String season;
//    private LocalDateTime date;
    private String distance;
    private RaceStatistics raceStatistics;
}
