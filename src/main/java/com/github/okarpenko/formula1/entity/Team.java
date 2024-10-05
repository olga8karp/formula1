package com.github.okarpenko.formula1.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Team {

    private int id;
    private String name;
    private String logo;
    private String base;
    private int first_team_entry;
    private int world_championships;
    private int pole_positions;
    private int fastest_laps;
    private String president;
    private String director;
    private String technical_manager;
    private String chassis;
    private String engine;
    private String tyres;
}