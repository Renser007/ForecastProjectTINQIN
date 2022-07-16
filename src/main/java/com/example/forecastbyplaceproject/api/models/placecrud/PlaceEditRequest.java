package com.example.forecastbyplaceproject.api.models.placecrud;


import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class PlaceEditRequest {

    private String placeName;
    private Double lat;
    private Double lon;

}
