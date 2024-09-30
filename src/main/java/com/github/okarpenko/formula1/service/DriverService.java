package com.github.okarpenko.formula1.service;

import com.github.okarpenko.formula1.entity.ranking.DriverWithRanking;
import com.github.okarpenko.formula1.entity.ranking.TeamRanking;
import com.github.okarpenko.formula1.repository.DriverRepository;
import com.github.okarpenko.formula1.repository.TeamRepository;
import com.github.okarpenko.formula1.service.client.Formula1HttpClient;
import com.github.okarpenko.formula1.service.client.responses.DriverResponse;
import com.github.okarpenko.formula1.service.client.responses.RankingResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DriverService {

    private final Formula1HttpClient httpClient;
    private final DriverRepository driverRepository;
    private final TeamRepository teamRepository;

    public Set<DriverWithRanking> getAllDrivers() {
        List<Integer> years = httpClient.getSeasons();
        List<RankingResponse> allRankingResponses = new ArrayList<>();
        for (int year : years) {
            allRankingResponses.addAll(httpClient.getRankingBySeason(year));
        }
        Set<DriverWithRanking> drivers = new TreeSet<>();
        Set<TeamRanking> teams = new HashSet<>();
        for (RankingResponse rankingResponse : allRankingResponses) {
            TeamRanking team = rankingResponse.getTeam();
            DriverWithRanking driver = rankingResponse.getDriver();
            // add team here
            drivers.add(driver);
            teams.add(team);
        }
        saveAllTeams(teams);
        return drivers;
    }


    public void saveAllDrivers(Set<DriverWithRanking> drivers) {
        driverRepository.saveAll(drivers);
    }

    public void saveAllTeams(Set<TeamRanking> teamRankings) {
        teamRepository.saveAll(teamRankings);
    }
}
