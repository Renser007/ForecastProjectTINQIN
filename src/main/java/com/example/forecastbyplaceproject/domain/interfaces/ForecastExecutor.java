package com.example.forecastbyplaceproject.domain.interfaces;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.WeatherResponse;
import com.example.forecastbyplaceproject.data.exceptions.CustomException;

public interface ForecastExecutor {

    WeatherResponse execute(WeatherRequest weatherRequest) throws CustomException;

}
