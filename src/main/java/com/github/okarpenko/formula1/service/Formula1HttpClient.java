package com.github.okarpenko.formula1.service;

import com.github.okarpenko.formula1.config.Formula1HttpClientProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class Formula1HttpClient {

    public static final String X_RAPIDAPI_HOST = "x-rapidapi-host";

    public static final String X_RAPIDAPI_KEY = "x-rapidapi-key";

    private final RestTemplate restTemplate;
    private final Formula1HttpClientProperties properties;

    public Formula1HttpClient(RestTemplateBuilder restTemplateBuilder, Formula1HttpClientProperties properties) {
        this.restTemplate = restTemplateBuilder
                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .defaultHeader(ACCEPT, APPLICATION_JSON_VALUE)
                .defaultHeader(X_RAPIDAPI_HOST, properties.getHost())
                .defaultHeader(X_RAPIDAPI_KEY, properties.getApiKey())
                .build();
        this.properties = properties;
    }

    public List<CircuitsResponse> getCircuits() {
        String url = UriComponentsBuilder.fromHttpUrl(properties.getBaseUrl())
                .path("/circuits")
                .encode()
                .toUriString();
        CircuitsListResponse circuitsListResponse = restTemplate.getForObject(url, CircuitsListResponse.class);
        return circuitsListResponse.getResponse();
    }

    public CircuitsResponse getCircuitById(Long id) {
        String url = UriComponentsBuilder.fromHttpUrl(properties.getBaseUrl())
                .path("/circuits")
                .query("id={id}")
                .buildAndExpand(id)
                .encode()
                .toUriString();

        CircuitsListResponse circuitsListResponse = restTemplate.getForObject(url, CircuitsListResponse.class);
        return circuitsListResponse.getResponse().getFirst();
    }

    @Getter
    @Setter
    public static class CircuitsResponse {
        private Long id;
        private String name;
        private String image;
    }

    @Setter
    @Getter
    public static class CircuitsListResponse {
        private List<CircuitsResponse> response;
    }


}