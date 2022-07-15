package com.example.forecastbyplaceproject.domain;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.WeatherResponse;
import com.example.forecastbyplaceproject.data.services.interfaces.PlaceService;
import com.example.forecastbyplaceproject.domain.interfaces.ForecastExecutor;
import org.springframework.stereotype.Service;

@Service
public class ForecastExecutorImpl implements ForecastExecutor {

    private final PlaceService placeService;

    public ForecastExecutorImpl(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Override
    public WeatherResponse execute(WeatherRequest weatherRequest) {

        return placeService.getWeatherByCountry(weatherRequest);
    }
}
