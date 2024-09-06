package com.github.okarpenko.formula1.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Driver {

    @Id
    @Column(name = "driver_id")
    private int id;
    private String name;
    private String abbr;
    private String image;
    private String nationality;
    private String country;
    private String birthdate;
    private String birthplace;
    private int number;
    private int grandsPrixEntered;
    private int worldChampionships;
    private int podiums;
    private int highestGridPosition;
    private int careerPoints;
    @ManyToMany(mappedBy = "drivers", cascade=CascadeType.ALL)
    private List<Team> teams;
}