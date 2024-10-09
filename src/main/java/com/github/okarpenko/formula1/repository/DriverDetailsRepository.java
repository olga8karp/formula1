package com.github.okarpenko.formula1.repository;

import com.github.okarpenko.formula1.entity.DriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDetailsRepository extends JpaRepository<DriverDetails, Integer> {

}
