package com.github.okarpenko.formula1.entity.details;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DriverInfoDetails {

    @JsonProperty("driver_number")
    private int driverNumber;
    private String broadcastName;
    private String fullName;
    @JsonProperty("name_acronym")
    private String nameAcronym;
    private String teamName;
    private String teamColour;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("headshot_url")
    private String headshotUrl;
    @JsonProperty("country_code")
    private String countryCode;
    private int sessionKey;
    private int meetingKey;
}
