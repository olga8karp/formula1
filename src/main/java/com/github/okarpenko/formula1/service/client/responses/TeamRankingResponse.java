package com.github.okarpenko.formula1.service.client.responses;

import com.github.okarpenko.formula1.entity.ranking.TeamWithRanking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamRankingResponse {

    private int position;
    private TeamWithRanking team;
    private String points;
    private Integer season;
}
