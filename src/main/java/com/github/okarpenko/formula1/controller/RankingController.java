package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.service.RankingService;
import com.github.okarpenko.formula1.service.client.Formula1HttpClient;
import com.github.okarpenko.formula1.service.client.responses.DriverRankingResponse;
import com.github.okarpenko.formula1.service.client.responses.TeamRankingResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class RankingController {

    private final RankingService rankingService;
    private final Formula1HttpClient httpClient;

    @GetMapping("/driver/rankings/{season}")
    public String getDriverRanking(@PathVariable Integer season, Model model)  {
        List<DriverRankingResponse> driverRankingPage = rankingService.findDriverRankings(season);
        List<Integer> seasons = httpClient.getSeasons();
        model.addAttribute("driverRanking", driverRankingPage);
        model.addAttribute("seasons", seasons);
        return "driver-ranking";
    }

    @GetMapping("/team/rankings/{season}")
    public String getTeamRanking(@PathVariable Integer season, Model model)  {
        // TODO: implement this part
        List<TeamRankingResponse> driverRankingPage = rankingService.findTeamRankings(season);
        List<Integer> seasons = httpClient.getSeasons();
        model.addAttribute("teamRanking", driverRankingPage);
        model.addAttribute("seasons", seasons);
        return "teams-ranking";
    }

}
