package com.example.forecastbyplaceproject.domain.services.interfaces;

import com.example.forecastbyplaceproject.data.entities.forecast.Forecast;

public interface ForecastService {

    Forecast getForecast(String lat, String lon);

}
