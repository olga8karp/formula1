package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.service.RankingService;
import com.github.okarpenko.formula1.service.client.responses.RankingResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class RankingController {

    private final RankingService rankingService;

    @GetMapping("/ranking")
    public String getDriverRanking(Pageable pageable, int year, Model model)  {
        List<RankingResponse> driverRankingPage = rankingService.findRankings(year);
        model.addAttribute("driverRanking", driverRankingPage);
        return "";
    }

}
