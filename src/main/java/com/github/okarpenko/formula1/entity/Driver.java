package com.github.okarpenko.formula1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
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
    @OneToOne
    private HighestRaceFinish highestRaceFinish;
    @OneToMany
    private List<Team> teams;
}