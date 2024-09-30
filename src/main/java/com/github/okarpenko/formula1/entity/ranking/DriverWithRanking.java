package com.github.okarpenko.formula1.entity.ranking;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DriverWithRanking implements Comparable<DriverWithRanking> {

    @Id
    private int id;
    private String name;
    private String abbr;
    private int number;
    private String image;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DriverWithRanking that)) {
            return false;
        }
        return id == that.id && number == that.number && Objects.equals(name, that.name)
            && Objects.equals(abbr, that.abbr) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, abbr, number, image);
    }

    @Override
    public int compareTo(@NotNull DriverWithRanking driverWithRanking) {
        if (this.id < driverWithRanking.id) {
            return -1;
        } else if (this.id > driverWithRanking.id) {
            return 1;
        }
        return 0;
    }
}
