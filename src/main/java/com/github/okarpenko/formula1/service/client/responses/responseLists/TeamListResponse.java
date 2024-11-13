package com.github.okarpenko.formula1.service.client.responses.responseLists;

import com.github.okarpenko.formula1.entity.Team;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeamListResponse {

    private List<Team> response;
}