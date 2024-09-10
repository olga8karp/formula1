package com.github.okarpenko.formula1.service.client.responses;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverResponse {

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
    List<TeamResponse> teams;
}