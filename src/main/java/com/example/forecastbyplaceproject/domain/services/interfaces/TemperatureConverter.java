package com.example.forecastbyplaceproject.domain.services.interfaces;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.data.entities.forecast.Forecast;

public interface TemperatureConverter {

    String convertToFahrenheit(WeatherRequest weatherRequest, Forecast forecast);

}
