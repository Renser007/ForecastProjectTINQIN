package com.example.forecastbyplaceproject.data.services.placecrud;

import com.example.forecastbyplaceproject.api.models.placecrud.PlaceEditRequest;
import com.example.forecastbyplaceproject.data.entities.Place;
import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.data.services.placecrud.interfaces.PlaceUpdateService;
import org.springframework.stereotype.Service;

@Service
public class PlaceUpdateServiceImpl implements PlaceUpdateService {

    private final PlaceRepository placeRepository;

    public PlaceUpdateServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public void updatePlace(PlaceEditRequest placeEditRequest, Long id) {

        Place wantedPlace = placeRepository.getReferenceById(id);

        wantedPlace.setPlaceName(placeEditRequest.getPlaceName());
        wantedPlace.setLat(placeEditRequest.getLat());
        wantedPlace.setLon(placeEditRequest.getLon());
        placeRepository.save(wantedPlace);

    }
}
