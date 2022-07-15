package com.example.startingproject.domain.interfaces;

import com.example.startingproject.domain.models.Coordinates;
import com.example.startingproject.domain.models.Weather;

public interface WeatherService {

    public Weather getForecast(Coordinates coordinates);

}
