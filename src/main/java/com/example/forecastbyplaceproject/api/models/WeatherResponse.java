package com.example.forecastbyplaceproject.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class WeatherResponse {

    @JsonProperty("Място")
    private String place;
    private String country;
    private String type;
    private String temperature;
    private String localTime;
}
