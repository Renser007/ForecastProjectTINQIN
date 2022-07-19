package com.example.forecastbyplaceproject.domain.services.placecrud.interfaces;

import com.example.forecastbyplaceproject.data.entities.mappers.PlaceGetResponseMapper;

import java.util.List;

public interface PlaceFindService {

    List<PlaceGetResponseMapper> findPlaceByName(String placeName);

}
