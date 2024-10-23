package com.github.okarpenko.formula1.service.client.responses.responseLists;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.okarpenko.formula1.entity.race.Race;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RacesListResponse {

    @JsonProperty("response")
    private List<Race> racesResponseList;
}
