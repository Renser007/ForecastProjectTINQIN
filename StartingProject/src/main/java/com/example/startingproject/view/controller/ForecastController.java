package com.example.startingproject.view.controller;

import com.example.startingproject.domain.interfaces.LocationService;
import com.example.startingproject.domain.interfaces.WeatherService;
import com.example.startingproject.domain.mappers.WeatherMapper;
import com.example.startingproject.domain.models.Coordinates;
import com.example.startingproject.domain.requests.WeatherRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class ForecastController {

    private final WeatherService weatherService;
    private final WeatherMapper weatherMapper;
    private final LocationService locationService;

    public ForecastController(WeatherService weatherService, WeatherMapper weatherMapper, LocationService locationService) {
        System.out.println("Created Controller");
        this.weatherService = weatherService;
        this.weatherMapper = weatherMapper;
        this.locationService = locationService;
    }

    @GetMapping("/")
    public String getHelloWorldString(){
        return ("Hello World!");
    }

    @PostMapping("/createForecast")
    public String getForecast(@RequestBody WeatherRequest weatherRequest){
        return weatherMapper.getWeather(weatherService.getForecast(
                Coordinates.builder().x(Double.parseDouble(weatherRequest.getX())).y(Double.parseDouble(weatherRequest.getY())).build()));
    }

    @PostMapping("/location")
    public String getWeatherForLocation(@RequestBody String label){
        return weatherMapper.getWeather(weatherService.getForecast(locationService.getLocationCoordinates(label)));
    }
}
