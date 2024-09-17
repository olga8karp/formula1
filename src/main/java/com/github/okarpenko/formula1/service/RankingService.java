package com.github.okarpenko.formula1.service;

import com.github.okarpenko.formula1.service.client.Formula1HttpClient;
import com.github.okarpenko.formula1.service.client.responses.RankingResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RankingService {

    private final Formula1HttpClient httpClient;

    public List<RankingResponse> findRankings(int year)  {
        List<RankingResponse> rankings = httpClient.getRankingBySeason(year);
        return rankings;
    }

}
