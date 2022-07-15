package com.example.startingproject.domain.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter()
@Getter
@ToString
public class WeatherStationRequest {

    private String name;
    private Double lan;
    private Double lon;
    private Double seaLevel;
    private Boolean type;

}
