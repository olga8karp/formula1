package com.github.okarpenko.formula1.service;

import com.github.okarpenko.formula1.service.client.Formula1HttpClient;
import com.github.okarpenko.formula1.service.client.responses.DriverRankingResponse;
import com.github.okarpenko.formula1.service.client.responses.TeamRankingResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RankingService {

    private final Formula1HttpClient httpClient;

    public List<DriverRankingResponse> findDriverRankings(int year)  {
        return httpClient.getDriverRankingBySeason(year);
    }

    public List<TeamRankingResponse> findTeamRankings(int year)  {
        return httpClient.getTeamRankingsBySeason(year);
    }

}
