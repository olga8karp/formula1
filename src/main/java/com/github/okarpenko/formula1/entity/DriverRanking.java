package com.github.okarpenko.formula1.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverRanking {

    private int position;
    private Driver driver;
    private Team team;
    private int points;
    private int wins;
    private int behind;
    private int season;
}
