package com.github.okarpenko.formula1.entity.ranking;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TeamRanking {

    @Id
    private int id;
    private String name;
    private String logo;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TeamRanking that)) {
            return false;
        }
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(logo, that.logo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, logo);
    }
}
