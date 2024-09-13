package com.github.okarpenko.formula1.service;

import com.github.okarpenko.formula1.entity.DriverRanking;
import com.github.okarpenko.formula1.service.client.Formula1HttpClient;
import com.github.okarpenko.formula1.service.client.responses.RankingResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RankingService {

    private final Formula1HttpClient httpClient;

    public Page<DriverRanking> findAll(Pageable pageable, int year) {
        List<DriverRanking> rankings = httpClient.getRankingBySeason(year).stream()
            .map(RankingService::mapDtoToEntity)
            .toList();
        return new PageImpl<>(
            rankings,
            pageable,
            rankings.size()
        );
    }

    private static DriverRanking mapDtoToEntity(RankingResponse rankingResponse) {
        DriverRanking driverRanking = new DriverRanking();
        driverRanking.setPosition(rankingResponse.getPosition());
//        driverRanking.setDriver(rankingResponse.getDriver());
//        driverRanking.setTeam(rankingResponse.getTeam());
        driverRanking.setPoints(rankingResponse.getPoints());
        driverRanking.setWins(rankingResponse.getWins());
        driverRanking.setBehind(rankingResponse.getBehind());
        return driverRanking;
    }

}
