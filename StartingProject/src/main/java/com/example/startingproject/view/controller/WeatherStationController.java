package com.example.startingproject.view.controller;

import com.example.startingproject.domain.requests.WeatherStationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherStationController {

    @PostMapping("/weatherStation")
    public String getWeatherRequest(@RequestBody WeatherStationRequest weatherStationRequest){
        return weatherStationRequest.toString();
    }

}
