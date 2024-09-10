package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.entity.DriverRanking;
import com.github.okarpenko.formula1.service.RankingService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class RankingController {

    private final RankingService rankingService;

    @GetMapping("/ranking")
    public String getDriverRanking(Pageable pageable, int year, Model model) {
        Page<DriverRanking> driverRankingPage = rankingService.findAll(pageable, year);
        model.addAttribute("driverRanking", driverRankingPage);
        return "";
    }

}
