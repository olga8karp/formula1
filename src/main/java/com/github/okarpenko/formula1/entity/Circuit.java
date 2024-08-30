package com.github.okarpenko.formula1.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Circuit {
    @Id
    private Long id;
    private String name;
    private String image;
}
