package com.example.startingproject.domain.requests;

import lombok.*;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
@ToString
public class LocationRequest {

    private String label;
    private Double lon;
    private Double lan;
}
