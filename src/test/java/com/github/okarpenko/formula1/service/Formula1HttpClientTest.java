package com.github.okarpenko.formula1.service;

import com.github.okarpenko.formula1.config.Formula1HttpClientProperties;
import com.github.okarpenko.formula1.service.client.Formula1HttpClient;
import com.github.okarpenko.formula1.service.client.responses.CircuitsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import java.util.List;

import static com.github.okarpenko.formula1.service.client.Formula1HttpClient.X_RAPIDAPI_HOST;
import static com.github.okarpenko.formula1.service.client.Formula1HttpClient.X_RAPIDAPI_KEY;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest
class Formula1HttpClientTest {

    private final Formula1HttpClient client;
    private final MockRestServiceServer mockRestServiceServer;

    @Autowired
    Formula1HttpClientTest(RestTemplateBuilder restTemplateBuilder, MockRestServiceServer mockRestServiceServer) {
        this.mockRestServiceServer = mockRestServiceServer;
        Formula1HttpClientProperties properties = new Formula1HttpClientProperties();
        properties.setApiKey("SECRET");
        properties.setBaseUrl("https://v1.formula-1.api-sports.io");
        properties.setHost("v1.formula-1.api-sports.io");
        this.client = new Formula1HttpClient(restTemplateBuilder, properties);
    }

    @Test
    void getCircuits() {
        mockRestServiceServer.expect(requestTo("https://v1.formula-1.api-sports.io/circuits"))
                .andExpect(header(X_RAPIDAPI_HOST, "v1.formula-1.api-sports.io"))
                .andExpect(header(X_RAPIDAPI_KEY, "SECRET"))
                .andRespond(
                        withSuccess()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(new ClassPathResource("formula-1-api/responses/get-circuits-ok.json"))
                );

        List<CircuitsResponse> circuits = client.getCircuits();
        assertNotNull(circuits);
    }


}