package com.github.okarpenko.formula1.service.client.responses;

import com.github.okarpenko.formula1.entity.ranking.DriverWithRanking;
import com.github.okarpenko.formula1.entity.ranking.TeamWithRanking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverRankingResponse {

    private int position;
    private DriverWithRanking driver;
    private TeamWithRanking team;
    private String points;
    private Integer wins;
    private Integer behind;
    private Integer season;
}
