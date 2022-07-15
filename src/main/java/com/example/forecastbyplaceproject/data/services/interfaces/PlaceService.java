package com.example.forecastbyplaceproject.data.services.interfaces;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.WeatherResponse;

public interface PlaceService {

    WeatherResponse getWeatherByCountry(WeatherRequest weatherRequest);

}
