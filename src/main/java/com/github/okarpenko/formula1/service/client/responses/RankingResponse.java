package com.github.okarpenko.formula1.service.client.responses;

import com.github.okarpenko.formula1.entity.Driver;
import com.github.okarpenko.formula1.entity.Team;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RankingResponse {

    private int position;
    private Driver driver;
    private Team team;
    private int points;
    private int wins;
    private int behind;
    private int season;
}
