package com.github.okarpenko.formula1.controller.admin;

import com.github.okarpenko.formula1.entity.details.TeamDetails;
import com.github.okarpenko.formula1.service.TeamDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminViewController {

    private final TeamDetailsService teamDetailsService;

    @PostMapping("/admin/create-teamDetails")
    public String addTeamDetails(@RequestParam("team-name") String teamName,
        @RequestParam("image-link") String teamLogo,
        @RequestParam("team-description") String basicInfo) throws InterruptedException {
        TeamDetails teamDetails = new TeamDetails();
        teamDetails.setName(teamName);
        teamDetails.setTeamLogo(teamLogo);
        teamDetails.setBasicInfo(basicInfo);
        try {
            TeamDetails teamDetailsResult = teamDetailsService.addTeamsDetails(teamDetails);
            log.info("[addTeamDetails] Team with name {} was successfully added", teamName);
        } catch (Exception e) {
            // pass error message to the view
            return "redirect:/admin/add-team?errorMessage=" + e.getMessage();
        }
        return "redirect:/team-info/name=" + teamName.trim();
    }

}
