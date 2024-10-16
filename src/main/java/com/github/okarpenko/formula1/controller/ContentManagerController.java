package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.entity.details.DriverDetails;
import com.github.okarpenko.formula1.entity.details.TeamDetails;
import com.github.okarpenko.formula1.service.DriverDetailsService;
import com.github.okarpenko.formula1.service.TeamDetailsService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ContentManagerController {

    private final DriverDetailsService driverDetailsService;
    private final TeamDetailsService teamDetailsService;

    @PostMapping("/drivers/details")
    public ResponseEntity<DriverDetails> addDriverDetails(@RequestBody DriverDetails driverDetails) {
        return ResponseEntity.ok(driverDetailsService.addDriverDetails(driverDetails));
    }

    @GetMapping("/drivers/details/list")
    public ResponseEntity<List<DriverDetails>> listDriverDetails() {
        return ResponseEntity.ok(driverDetailsService.listDriverDetails());
    }

    @PostMapping("/teams/details")
    public ResponseEntity<TeamDetails> addTeamsDetails(@RequestBody TeamDetails teamDetails) {
        return ResponseEntity.ok(teamDetailsService.addTeamsDetails(teamDetails));
    }

    @GetMapping("/teams/details/list")
    public ResponseEntity<List<TeamDetails>> listTeamDetails() {
        return ResponseEntity.ok(teamDetailsService.listTeamDetails());
    }
}
