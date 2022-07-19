package com.example.forecastbyplaceproject.domain.services;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.data.entities.mappers.WeatherResponseMapper;
import com.example.forecastbyplaceproject.data.entities.forecast.Forecast;
import com.example.forecastbyplaceproject.data.exceptions.CustomException;
import com.example.forecastbyplaceproject.data.repositories.CountryRepository;
import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.domain.services.interfaces.ForecastService;
import com.example.forecastbyplaceproject.domain.services.interfaces.PlaceService;
import com.example.forecastbyplaceproject.domain.services.interfaces.TemperatureConverter;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Stream;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final ForecastService forecastService;
    private final CountryRepository countryRepository;
    private final PlaceRepository placeRepository;

    private final TemperatureConverter temperatureConverter;

    public PlaceServiceImpl(ForecastService forecastService, CountryRepository countryRepository, PlaceRepository placeRepository, TemperatureConverter temperatureConverter) {
        this.forecastService = forecastService;
        this.countryRepository = countryRepository;
        this.placeRepository = placeRepository;
        this.temperatureConverter = temperatureConverter;
    }


    @Override
    public WeatherResponseMapper getWeatherByCountry(WeatherRequest weatherRequest) throws CustomException {



        /* Country country = countryRepository.getCountriesByCountryName(weatherRequest.getCountry());

        if (country == null) {
            throw new CustomException("Country doesn't exist!");
        }

        Place place = placeRepository.findByCountryAndPlaceName(country, weatherRequest.getPlace());

        if (place == null) {
            throw new CustomException("Place doesn't exist!");
        }

        Forecast forecast = forecastService.getForecast(place.getLon().toString(), place.getLat().toString());

        String temperature = temperatureConverter.convertToFahrenheit(weatherRequest, forecast);

        return WeatherResponseMapper.builder()
                .place(place.getPlaceName())
                .country(place.getCountry().getCountryName())
                .type(place.getType().getTypeName())
                .temperature(temperature)
                .localTime(forecast.getLocation().getLocaltime())
                .build();*/

        return Stream.of(countryRepository.getCountriesByCountryName(weatherRequest.getCountry()))
                .filter(Objects::nonNull)
                .map(country -> placeRepository.findByCountryAndPlaceName(country, weatherRequest.getPlace()))
                .filter(Objects::nonNull)
                .map(place -> {
                        Forecast forecast = forecastService.getForecast(place.getLon().toString(), place.getLat().toString());
                        String temperature = temperatureConverter.convertToFahrenheit(weatherRequest, forecast);
                        return WeatherResponseMapper.builder()
                                .place(place.getPlaceName())
                                .country(place.getCountry().getCountryName())
                                .type(place.getType().getTypeName())
                                .temperature(temperature)
                                .localTime(forecast.getLocation().getLocaltime())
                                .build();
                }).findAny().orElseThrow();

    }
}
