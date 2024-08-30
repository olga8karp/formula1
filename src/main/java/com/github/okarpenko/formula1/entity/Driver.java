package com.github.okarpenko.formula1.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver {
    @Id
    int id;
    String name;
    String abbr;
    String image;
    String nationality;
    String country;
    String birthdate;
    String birthplace;
    int number;
    int grands_prix_entered;
    int world_championships;
    int podiums;
    int highest_grid_position;
    int career_points;
    HighestRaceFinish highest_race_finish;
    Team[] teams;
}