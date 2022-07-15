package com.example.forecastbyplaceproject.data.services;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.api.models.WeatherResponse;
import com.example.forecastbyplaceproject.data.entities.Country;
import com.example.forecastbyplaceproject.data.entities.Place;
import com.example.forecastbyplaceproject.data.entities.forecast.Forecast;
import com.example.forecastbyplaceproject.data.repositories.CountryRepository;
import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.data.services.interfaces.ForecastService;
import com.example.forecastbyplaceproject.data.services.interfaces.PlaceService;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final ForecastService forecastService;
    private final CountryRepository countryRepository;
    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(ForecastService forecastService, CountryRepository countryRepository, PlaceRepository placeRepository) {
        this.forecastService = forecastService;
        this.countryRepository = countryRepository;
        this.placeRepository = placeRepository;
    }


    @Override
    public WeatherResponse getWeatherByCountry(WeatherRequest weatherRequest) {



        Country country = countryRepository.getCountriesByCountryName(weatherRequest.getCountry());

        if (country == null) {
            throw new NullPointerException();
        }

        Place place = placeRepository.findByCountryAndPlaceName(country, weatherRequest.getPlace());

        if (place == null) {
            throw new NullPointerException();
        }
        Forecast forecast = forecastService.getForecast(place.getLon().toString(), place.getLat().toString());

        WeatherResponse weatherResponse = WeatherResponse.builder()
                .place(place.getPlaceName())
                .country(place.getCountry().getCountryName())
                .type(place.getType().getTypeName())
                .temperature(String.valueOf(forecast.getCurrent().getTemp_c()))
                .localTime(forecast.getLocation().getLocaltime())
                .build();

        return weatherResponse;
    }
}
