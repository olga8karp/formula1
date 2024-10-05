package com.github.okarpenko.formula1.entity;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverResponse {

    private int id;
    private String name;
    private String abbr;
    private String image;
    private String nationality;
    private String birthdate;
    private String birthplace;
    private int number;
    private int grands_prix_entered;
    private int world_championships;
    private int podiums;
    private int highest_grid_position;
    private double career_points;
    private HighestRaceFinish highest_race_finish;
    private List<Team> teams;

}