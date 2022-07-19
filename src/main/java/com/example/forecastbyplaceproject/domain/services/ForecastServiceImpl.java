package com.example.forecastbyplaceproject.domain.services;

import com.example.forecastbyplaceproject.data.entities.forecast.Forecast;
import com.example.forecastbyplaceproject.data.resttemplate.implement.RestTemplateProviderImpl;
import com.example.forecastbyplaceproject.domain.services.interfaces.ForecastService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Primary
public class ForecastServiceImpl implements ForecastService {

    private final RestTemplateProviderImpl restTemplateProvider;


    public ForecastServiceImpl(RestTemplateProviderImpl restTemplateProvider) {
        this.restTemplateProvider = restTemplateProvider;
    }

    @Override
    public Forecast getForecast(String lat, String lon) {
        final String url = "http://api.weatherapi.com/v1/current.json?key=430a23fb164142c9b7590214220807&q=" + lon + "," + lat; //43.204666,27.910543 - varna

        RestTemplate restTemplate = restTemplateProvider.getRestTemplate();

        return restTemplate.getForObject(url, Forecast.class);
    }
}
