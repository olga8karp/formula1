package com.github.okarpenko.formula1.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Race {
    @Id
    private int id;
    private String name;
    private Location location;
    private Circuit circuit;
    private String season;
    private String type;
    private Laps laps;
    private FastestLap fastest_lap;
    private String distance;
    private String timezone;
    private String date;
    private String weather;
    private String status;
}
