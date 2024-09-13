package com.github.okarpenko.formula1.service.client;

import com.github.okarpenko.formula1.config.Formula1HttpClientProperties;
import com.github.okarpenko.formula1.service.client.responses.responseLists.CircuitsListResponse;
import com.github.okarpenko.formula1.service.client.responses.CircuitsResponse;
import com.github.okarpenko.formula1.service.client.responses.DriverResponse;
import com.github.okarpenko.formula1.service.client.responses.responseLists.DriversListResponse;
import com.github.okarpenko.formula1.service.client.responses.RankingResponse;
import com.github.okarpenko.formula1.service.client.responses.responseLists.RankingListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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

    public List<DriverResponse> getDrivers() {
        String url = UriComponentsBuilder.fromHttpUrl(properties.getBaseUrl())
                .path("/drivers")
                .encode()
                .toUriString();
        DriversListResponse driversListResponse = restTemplate.getForObject(url, DriversListResponse.class);
        return driversListResponse.getResponse();
    }

    public DriverResponse getDriverByName(String name) {
        String url = UriComponentsBuilder.fromHttpUrl(properties.getBaseUrl())
                .path("/drivers")
                .query("search={name}")
                .buildAndExpand(name)
                .encode()
                .toUriString();

        DriversListResponse driversListResponse = restTemplate.getForObject(url, DriversListResponse.class);
        return driversListResponse.getResponse().getFirst();
    }

    public List<RankingResponse> getRankingBySeason(int year) {
        String url = UriComponentsBuilder.fromHttpUrl(properties.getBaseUrl())
            .path("/rankings/drivers")
            .query("season={year}")
            .buildAndExpand(year)
            .encode()
            .toUriString();
        RankingListResponse rankingResponseList = restTemplate.getForObject(url, RankingListResponse.class);
        return rankingResponseList.getRankingResponseList();
    }

}
