package com.example.forecastbyplaceproject.data.services.placecrud;

import com.example.forecastbyplaceproject.data.entities.Place;
import com.example.forecastbyplaceproject.data.entities.mappers.PlaceGetResponseMapper;
import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.data.services.placecrud.interfaces.PlaceGetService;
import org.springframework.stereotype.Service;

@Service
public class PlaceGetServiceImpl implements PlaceGetService {

    private final PlaceRepository placeRepository;

    public PlaceGetServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public PlaceGetResponseMapper getPlaceById(Long id) {

        Place wantedPlace = placeRepository.getReferenceById(id);

        return PlaceGetResponseMapper.builder()
                .placeName(wantedPlace.getPlaceName())
                .country(wantedPlace.getCountry().getCountryName())
                .lat(wantedPlace.getLat())
                .lon(wantedPlace.getLon())
                .type(wantedPlace.getType().getTypeName())
                .build();
    }
}
