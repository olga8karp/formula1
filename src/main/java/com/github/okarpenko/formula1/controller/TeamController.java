package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.entity.details.TeamDetails;
import com.github.okarpenko.formula1.service.TeamDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@Controller
public class TeamController {

    private TeamDetailsService teamDetailsService;

    @GetMapping(path = "/teams")
    public String driversPage() {
        return "teams";
    }

    @GetMapping("/team-info/{name}")
    public String getDriverPage(@PathVariable("name") String name, Model model){
        TeamDetails teamDetails = teamDetailsService.retrieveTeamDetailsByName(name);
        model.addAttribute("teamDetails", teamDetails);
        return "team-page";
    }

}
