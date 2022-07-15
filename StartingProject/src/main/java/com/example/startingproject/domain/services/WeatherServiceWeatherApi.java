package com.example.startingproject.domain.services;


import com.example.startingproject.domain.interfaces.WeatherService;
import com.example.startingproject.domain.models.weatherapi.ApiWeather;
import com.example.startingproject.domain.models.Coordinates;
import com.example.startingproject.domain.models.Weather;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Primary
public class WeatherServiceWeatherApi implements WeatherService {

    RestTemplateProviderImpl restTemplateProvider;

    public WeatherServiceWeatherApi(RestTemplateProviderImpl restTemplateProvider) {
        this.restTemplateProvider = restTemplateProvider;
        System.out.println("Created WeatherServiceWeatherApi");
    }

    @Override
    public Weather getForecast(Coordinates coordinates) {
        final String url = "http://api.weatherapi.com/v1/current.json?key=430a23fb164142c9b7590214220807&q=" + coordinates.getX() + "," + coordinates.getY(); //43.204666,27.910543 - varna

        RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
        ApiWeather apiWeather = restTemplate.getForObject(url, ApiWeather.class);

        return Weather.builder()
                .weather(apiWeather.getCurrent().getCondition().getText())
                .location(apiWeather.getLocation().getRegion())
                .localTime(apiWeather.getLocation().getLocaltime())
                .coordinates(coordinates)
                .build();

    }
}
