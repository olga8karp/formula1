package com.github.okarpenko.formula1.service;

import com.github.okarpenko.formula1.config.Formula1HttpClientProperties;
import com.github.okarpenko.formula1.entity.Team;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

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
                .query("search=alo")
                .encode()
                .toUriString();
        DriversListResponse driversListResponse = restTemplate.getForObject(url, DriversListResponse.class);
        return driversListResponse.getResponse();
    }

    public DriverResponse getDriverById(Long id) {
        String url = UriComponentsBuilder.fromHttpUrl(properties.getBaseUrl())
                .path("/drivers")
                .query("id={id}")
                .buildAndExpand(id)
                .encode()
                .toUriString();

        DriversListResponse driversListResponse = restTemplate.getForObject(url, DriversListResponse.class);
        return driversListResponse.getResponse().getFirst();
    }

    public static abstract class RapidApiResponse<T> {
        private String get;
        private Map<String, Object> parameters;
        private List<String> errors;
        private Long results;
        private List<T> response;
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

    @Getter
    @Setter
    public static class DriverResponse {
        private int id;
        private String name;
        private String abbr;
        private String image;
        private String nationality;
        private String birthdate;
        private String birthplace;
        private int number;
        private int grands_prix_entered;
        private int world_championships;
        private int podiums;
        private int highest_grid_position;
        private double career_points;
        private HighestRaceFinish highest_race_finish;
        private List<Team> teams;
    }

    @Setter
    @Getter
    public static class DriversListResponse {
        private List<DriverResponse> response;
    }

    @Setter
    @Getter
    public static class TeamResponse {
        @Id
        private int id;
        private String name;
        private String logo;
        private String base;
        private int first_team_entry;
        private int world_championships;
        private HighestRaceFinish highest_race_finish;
        private int pole_positions;
        private int fastest_laps;
        private String president;
        private String director;
        private String technical_manager;
        private String chassis;
        private String engine;
        private String tyres;
    }

    @Getter
    @Setter
    public static class HighestRaceFinish {
        private int position;
        private int number;
    }
}
