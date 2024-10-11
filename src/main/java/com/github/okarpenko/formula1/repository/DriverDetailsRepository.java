package com.github.okarpenko.formula1.repository;

import com.github.okarpenko.formula1.entity.details.DriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDetailsRepository extends JpaRepository<DriverDetails, Integer> {

    public DriverDetails findDriverDetailsByLastName(String lastName);
}
