package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.service.RankingService;
import com.github.okarpenko.formula1.service.client.Formula1HttpClient;
import com.github.okarpenko.formula1.service.client.responses.RankingResponse;
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

    @GetMapping("/rankings/{season}")
    public String getDriverRanking(@PathVariable Integer season, Model model)  {
        List<RankingResponse> driverRankingPage = rankingService.findRankings(season);
        List<Integer> seasons = httpClient.getSeasons();
        model.addAttribute("driverRanking", driverRankingPage);
        model.addAttribute("seasons", seasons);
        return "rankings";
    }

}
