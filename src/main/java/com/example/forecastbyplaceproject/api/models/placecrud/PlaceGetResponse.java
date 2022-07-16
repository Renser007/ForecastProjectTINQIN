package com.example.forecastbyplaceproject.api.models.placecrud;


import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class PlaceGetResponse {

    private String placeName;
    private String country;
    private Double lat;
    private Double lon;
    private String type;

}
