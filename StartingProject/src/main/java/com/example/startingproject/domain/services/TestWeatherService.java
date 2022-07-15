package com.example.startingproject.domain.services;


import com.example.startingproject.domain.interfaces.WeatherService;
import com.example.startingproject.domain.models.Coordinates;
import com.example.startingproject.domain.models.Weather;
import org.springframework.stereotype.Service;

@Service
public class TestWeatherService implements WeatherService {

    public TestWeatherService() {

        System.out.println("Created TestWeatherService");

    }

    @Override
    public Weather getForecast(Coordinates coordinates) {
        /*Weather weather = new Weather("Sunny", "Varna", "12.34", coordinates);*/

        return Weather.builder()
                .weather("Sunny")
                .location("Varna")
                .localTime("12.34")
                .coordinates(coordinates)
                .build();
    }
}
