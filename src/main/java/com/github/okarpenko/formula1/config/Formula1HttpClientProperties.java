package com.github.okarpenko.formula1.config;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix = "formula1-api")
@Validated
@Getter
@Setter
public class Formula1HttpClientProperties {

    @NotEmpty
    @Value("${formula1-api.api-key}")
    private String apiKey;

    @NotEmpty
    @Value("${formula1-api.base-url}")
    private String baseUrl;

    @NotEmpty
    @Value("${formula1-api.host}")
    private String host;
}
