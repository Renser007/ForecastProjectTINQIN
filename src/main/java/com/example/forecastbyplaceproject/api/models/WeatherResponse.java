package com.example.forecastbyplaceproject.api.models;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class WeatherResponse {

    private String place;
    private String country;
    private String type;
    private String temperature;
    private String localTime;
}
