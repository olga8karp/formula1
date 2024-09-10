package com.github.okarpenko.formula1.service.client.responses;

import java.util.List;
import java.util.Map;

public  abstract class RapidApiResponse<T> {
        private String get;
        private Map<String, Object> parameters;
        private List<String> errors;
        private Long results;
        private List<T> response;
    }
