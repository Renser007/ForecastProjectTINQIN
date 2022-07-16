package com.example.forecastbyplaceproject.data.services.placecrud;


import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.data.services.placecrud.interfaces.PlaceDeleteService;
import org.springframework.stereotype.Service;

@Service
public class PlaceDeleteServiceImpl implements PlaceDeleteService {

    private final PlaceRepository placeRepository;

    public PlaceDeleteServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public void deletePlace(Long id) {

        placeRepository.deleteById(id);

    }
}
