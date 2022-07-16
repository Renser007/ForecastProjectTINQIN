package com.example.forecastbyplaceproject.api.models.placecrud;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class PlaceCreateRequest {

    private String name;
    private String country;
    private String type;
    private Double lat;
    private Double lon;

}
