package com.example.forecastbyplaceproject.api.models;

import com.example.forecastbyplaceproject.customserializer.BooleanCustomDeserializer;
import com.example.forecastbyplaceproject.customserializer.BooleanCustomSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
@Jacksonized
public class WeatherRequest {
    @JsonSerialize(using = BooleanCustomSerializer.class)
    @JsonDeserialize(using = BooleanCustomDeserializer.class)
    private Boolean isFahrenheit;
    @JsonProperty("Място")
    private String place;
    private String country;
}
