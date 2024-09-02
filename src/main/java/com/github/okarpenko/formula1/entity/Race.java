package com.github.okarpenko.formula1.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Race {
    @Id
    int id;
    String name;
    Location location;
    Circuit circuit;
    String season;
    String type;
    Laps laps;
    FastestLap fastest_lap;
    String distance;
    String timezone;
    String date;
    String weather;
    String status;
}
