package com.github.okarpenko.formula1.controller.admin;

import com.github.okarpenko.formula1.entity.details.TeamDetails;
import com.github.okarpenko.formula1.service.TeamDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminViewController {

    private final TeamDetailsService teamDetailsService;

    @PostMapping("/admin/create-teamDetails")
    public String addTeamDetails(@RequestParam("team-name") String teamName,
        @RequestParam("image-link") String teamLogo,
        @RequestParam("team-description") String basicInfo) {
        TeamDetails teamDetails = new TeamDetails();
        teamDetails.setName(teamName);
        teamDetails.setTeamLogo(teamLogo);
        teamDetails.setBasicInfo(basicInfo);
        try {
            teamDetailsService.addTeamsDetails(teamDetails);
        } catch (Exception e) {
            // pass error message to the view
            return "redirect:/admin/add-team?errorMessage=" + e.getMessage();
        }
        return "redirect:/admin";
    }

}
