package com.example.forecastbyplaceproject.data.entities.mappers;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class PlaceGetResponseMapper {
        private String placeName;
        private String country;
        private Double lat;
        private Double lon;
        private String type;
}
