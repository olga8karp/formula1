package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.entity.details.TeamDetails;
import com.github.okarpenko.formula1.service.TeamDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AdminActionsController {

    private TeamDetailsService teamDetailsService;

    @PatchMapping("/teams/{id}")
    public ResponseEntity<TeamDetails> editTeamDetails(@PathVariable("id") int id,
        @RequestBody TeamDetails teamDetails) {
        TeamDetails teamDetailsToUpdate = teamDetailsService.retrieveTeamDetailsById(id);
        teamDetailsToUpdate.setName(teamDetails.getName());
        teamDetailsToUpdate.setTeamLogo(teamDetails.getTeamLogo());
        teamDetailsService.addTeamsDetails(teamDetailsToUpdate);
        return ResponseEntity.ok(teamDetails);
    }

}
