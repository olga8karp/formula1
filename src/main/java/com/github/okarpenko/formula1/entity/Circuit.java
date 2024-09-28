package com.github.okarpenko.formula1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Entity
@Table(name = "circuit")
public class Circuit {

    @Id
    private Long id;
    private String name;
    private String image;
}
