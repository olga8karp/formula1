package com.github.okarpenko.formula1.config;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
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
    private String apiKey;

    @NotEmpty
    private String baseUrl;

    @NotEmpty
    private String host;
}
