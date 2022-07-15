package com.example.startingproject.domain.models.weatherapi;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ApiWeather {

    private Location location;
    private Current current;
}
