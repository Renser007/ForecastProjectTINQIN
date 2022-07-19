package com.example.forecastbyplaceproject.domain.services.interfaces;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.data.entities.mappers.WeatherResponseMapper;
import com.example.forecastbyplaceproject.data.exceptions.CustomException;

public interface PlaceService {

    WeatherResponseMapper getWeatherByCountry(WeatherRequest weatherRequest) throws CustomException;

}
