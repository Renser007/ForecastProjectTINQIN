package com.example.startingproject.domain.mappers;

import com.example.startingproject.domain.models.Weather;
import org.springframework.stereotype.Service;

@Service
public class WeatherMapper {

    public String getWeather(Weather weather){

        String weatherString = "Weather: " + weather.getWeather() + "   " + weather.getLocalTime() + "   " + weather.getLocation() + "   " + weather.getCoordinates();

        return weatherString;
    }
}
