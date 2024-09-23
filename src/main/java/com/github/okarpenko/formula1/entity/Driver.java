package com.github.okarpenko.formula1.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Driver {
    @Id
    private int id;
    private String name;
    private String abbr;
    private String image;
    private String nationality;
    private String birthdate;
    private String birthplace;
    private int number;
    private int grandsPrixEntered;
    private int worldChampionships;
    private int podiums;
    private int highestGridPosition;
    private double careerPoints;
    private HighestRaceFinish highestRaceFinish;
    private List<Team> teams;
}