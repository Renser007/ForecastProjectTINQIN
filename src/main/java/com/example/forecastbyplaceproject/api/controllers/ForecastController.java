package com.example.forecastbyplaceproject.api.controllers;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.WeatherResponse;
import com.example.forecastbyplaceproject.domain.interfaces.ForecastExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForecastController {

    private final ForecastExecutor forecastExecutor;

    public ForecastController(ForecastExecutor forecastExecutor) {
        this.forecastExecutor = forecastExecutor;
    }

    @PostMapping("/getWeather")
    public WeatherResponse getWeather(@RequestBody WeatherRequest weatherRequest){
        return forecastExecutor.execute(weatherRequest);
    }

}
