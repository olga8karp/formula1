package com.github.okarpenko.formula1.repository;

import com.github.okarpenko.formula1.entity.ranking.TeamWithRanking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamWithRanking, Long> {

}
