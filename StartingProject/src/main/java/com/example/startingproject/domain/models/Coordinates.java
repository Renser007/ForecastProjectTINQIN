package com.example.startingproject.domain.models;

import lombok.*;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
@ToString
public class Coordinates {

    private double x;
    private double y;

}
