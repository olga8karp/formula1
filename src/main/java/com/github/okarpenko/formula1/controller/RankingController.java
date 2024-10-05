package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.service.RankingService;
import com.github.okarpenko.formula1.service.client.responses.RankingResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class RankingController {

    private final RankingService rankingService;

    @GetMapping("/rankings")
    public String getDriverRanking(@RequestParam(defaultValue = "2023") Integer year, Model model)  {
        List<RankingResponse> driverRankingPage = rankingService.findRankings(year);
        model.addAttribute("driverRanking", driverRankingPage);
        return "rankings";
    }

}
