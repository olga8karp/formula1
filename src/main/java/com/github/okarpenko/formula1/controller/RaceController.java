package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.entity.race.Race;
import com.github.okarpenko.formula1.service.client.Formula1HttpClient;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class RaceController {

    private final Formula1HttpClient formula1HttpClient;

    @GetMapping(path = "/races/{season}")
    public String driversPage(@PathVariable Integer season, Model model) {
        List<Race> races = formula1HttpClient.getRacesListBySeason(season);
        List<Integer> seasons = formula1HttpClient.getSeasons();
        model.addAttribute("races", races);
        model.addAttribute("seasons", seasons);
        return "races";
    }
}
