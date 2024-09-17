package com.github.okarpenko.formula1.service.client.responses.responseLists;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.okarpenko.formula1.service.client.responses.RankingResponse;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RankingListResponse {

    @JsonProperty("response")
    private List<RankingResponse> rankingResponseList;
}
