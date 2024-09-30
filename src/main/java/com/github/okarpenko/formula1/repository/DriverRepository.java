package com.github.okarpenko.formula1.repository;

import com.github.okarpenko.formula1.entity.ranking.DriverWithRanking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverWithRanking, Long> {

}
