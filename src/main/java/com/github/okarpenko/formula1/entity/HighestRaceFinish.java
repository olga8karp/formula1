package com.github.okarpenko.formula1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class HighestRaceFinish {

    @Id
    private Long id;
    private int position;
    private int number;
}
