package com.example.forecastbyplaceproject.data.services.placecrud.interfaces;

import com.example.forecastbyplaceproject.data.entities.mappers.PlaceGetResponseMapper;

public interface PlaceGetService {

    PlaceGetResponseMapper getPlaceById(Long id);

}
