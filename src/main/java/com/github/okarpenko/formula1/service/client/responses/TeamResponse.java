package com.github.okarpenko.formula1.service.client.responses;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeamResponse {

    @Id
    private int id;
    private String name;
    private String logo;
    private String base;
    private int first_team_entry;
    private int world_championships;
    private HighestRaceFinish highest_race_finish;
    private int pole_positions;
    private int fastest_laps;
    private String president;
    private String director;
    private String technical_manager;
    private String chassis;
    private String engine;
    private String tyres;
}