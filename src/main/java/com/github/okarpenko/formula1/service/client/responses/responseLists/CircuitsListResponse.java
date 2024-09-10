package com.github.okarpenko.formula1.service.client.responses.responseLists;

import com.github.okarpenko.formula1.service.client.responses.CircuitsResponse;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CircuitsListResponse {

    private List<CircuitsResponse> response;
}