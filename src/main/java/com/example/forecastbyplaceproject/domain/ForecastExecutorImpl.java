package com.example.forecastbyplaceproject.domain;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.WeatherResponse;
import com.example.forecastbyplaceproject.data.exceptions.CustomException;
import com.example.forecastbyplaceproject.domain.services.interfaces.PlaceService;
import com.example.forecastbyplaceproject.domain.interfaces.ForecastExecutor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ForecastExecutorImpl implements ForecastExecutor {

    private final PlaceService placeService;

    public ForecastExecutorImpl(PlaceService placeService) {
        this.placeService = placeService;
    }

    @Override
    public WeatherResponse execute(WeatherRequest weatherRequest) throws CustomException {

            /*WeatherResponseMapper weatherResponseMapper= placeService.getWeatherByCountry(weatherRequest);
            return WeatherResponse.builder()
                    .place(weatherResponseMapper.getPlace())
                    .country(weatherResponseMapper.getCountry())
                    .type(weatherResponseMapper.getType())
                    .temperature(weatherResponseMapper.getTemperature())
                    .localTime(weatherResponseMapper.getLocalTime())
                    .build();*/

        return Stream.of(placeService.getWeatherByCountry(weatherRequest))
                .map(w -> WeatherResponse.builder()
                        .place(w.getPlace())
                        .country(w.getCountry())
                        .type(w.getType())
                        .temperature(w.getTemperature())
                        .localTime(w.getLocalTime())
                        .build())
                .findAny().orElseThrow();
    }
}
