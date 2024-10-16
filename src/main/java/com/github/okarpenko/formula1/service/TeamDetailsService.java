package com.github.okarpenko.formula1.service;

import com.github.okarpenko.formula1.entity.details.TeamDetails;
import com.github.okarpenko.formula1.repository.TeamDetailsRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamDetailsService {

    private final TeamDetailsRepository teamDetailsRepository;

    public TeamDetails addTeamsDetails(TeamDetails teamDetails) {
        return teamDetailsRepository.save(teamDetails);
    }

    public List<TeamDetails> listTeamDetails() {
        return teamDetailsRepository.findAll();
    }

    public TeamDetails retrieveTeamDetailsByName(String name) {
        return teamDetailsRepository.findTeamDetailsByName(name.trim());
    }

    public TeamDetails retrieveTeamDetailsById(Integer id) {
        return teamDetailsRepository.findById(id).orElse(null);
    }
}
