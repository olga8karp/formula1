package com.github.okarpenko.formula1.repository;

import com.github.okarpenko.formula1.entity.details.TeamDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TeamDetailsRepository extends JpaRepository<TeamDetails, Integer> {

    TeamDetails findTeamDetailsByName(String name);

    @Modifying
    @Transactional
    @Query("INSERT INTO TeamDetails (name, teamLogo, basicInfo) VALUES (:name, :teamLogo, :basicInfo)")
    void saveTeamDetails(@Param("name") String name, @Param("teamLogo") String teamLogo, @Param("basicInfo") String basicInfo);

}
