package com.example.forecastbyplaceproject.domain.services;

import com.example.forecastbyplaceproject.api.models.WeatherRequest;
import com.example.forecastbyplaceproject.data.entities.forecast.Forecast;
import com.example.forecastbyplaceproject.domain.services.interfaces.TemperatureConverter;
import org.springframework.stereotype.Service;

@Service
public class TemperatureConverterImpl implements TemperatureConverter {


    @Override
    public String convertToFahrenheit(WeatherRequest weatherRequest, Forecast forecast) { //dali moje sys stream

        if (weatherRequest.getIsFahrenheit()){
            double temperature = forecast.getCurrent().getTemp_c();
            temperature = ((temperature*1.8)+32);

            return Double.toString(temperature);

        }
        else{
        return String.valueOf(forecast.getCurrent().getTemp_c());}
    }
}
