package com.github.okarpenko.formula1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Team {

    @Id
    @Column(name = "team_id")
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

    @ManyToMany
    @JoinTable(name = "driver_team",
        joinColumns = @JoinColumn(name = "team_id"),
        inverseJoinColumns = @JoinColumn(name = "driver_id"))
    private List<Driver> drivers;
}