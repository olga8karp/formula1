package com.github.okarpenko.formula1.service.client.responses;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeamResponse {

    @Id
    int id;
    String name;
    String logo;
    String base;
    int first_team_entry;
    int world_championships;
    HighestRaceFinish highest_race_finish;
    int pole_positions;
    int fastest_laps;
    String president;
    String director;
    String technical_manager;
    String chassis;
    String engine;
    String tyres;
}