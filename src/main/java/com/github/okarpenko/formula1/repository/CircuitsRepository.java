package com.github.okarpenko.formula1.repository;

import com.github.okarpenko.formula1.entity.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CircuitsRepository extends JpaRepository<Circuit, Long> { }