package com.example.startingproject.domain.models;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class Weather {

    private String weather;
    private String location;
    private String localTime;
    private Coordinates coordinates;
}
