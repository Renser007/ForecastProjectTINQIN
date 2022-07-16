package com.example.forecastbyplaceproject.data.entities.mappers;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class WeatherResponseMapper {

    private String place;
    private String country;
    private String type;
    private String temperature;
    private String localTime;

}
