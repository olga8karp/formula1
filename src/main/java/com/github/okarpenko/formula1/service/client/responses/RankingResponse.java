package com.github.okarpenko.formula1.service.client.responses;

import com.github.okarpenko.formula1.entity.ranking.DriverRanking;
import com.github.okarpenko.formula1.entity.ranking.TeamRanking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RankingResponse {

    private int position;
    private DriverRanking driver;
    private TeamRanking team;
    private String points;
    private Integer wins;
    private Integer behind;
    private Integer season;
}
