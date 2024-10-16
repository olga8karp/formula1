package com.github.okarpenko.formula1.repository;

import com.github.okarpenko.formula1.entity.details.TeamDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDetailsRepository extends JpaRepository<TeamDetails, Integer> {

    TeamDetails findTeamDetailsByName(String name);

}
