package com.example.forecastbyplaceproject.domain;

import com.example.forecastbyplaceproject.api.models.placecrud.PlaceCreateRequest;
import com.example.forecastbyplaceproject.api.models.placecrud.PlaceEditRequest;
import com.example.forecastbyplaceproject.api.models.placecrud.PlaceGetResponse;
import com.example.forecastbyplaceproject.data.entities.mappers.PlaceGetResponseMapper;
import com.example.forecastbyplaceproject.data.services.placecrud.interfaces.PlaceCreateService;
import com.example.forecastbyplaceproject.data.services.placecrud.interfaces.PlaceDeleteService;
import com.example.forecastbyplaceproject.data.services.placecrud.interfaces.PlaceGetService;
import com.example.forecastbyplaceproject.data.services.placecrud.interfaces.PlaceUpdateService;
import com.example.forecastbyplaceproject.domain.interfaces.PlaceExecutor;
import org.springframework.stereotype.Service;

@Service
public class PlaceExecutorImpl implements PlaceExecutor {

    private final PlaceCreateService placeCreateService;
    private final PlaceGetService placeGetService;
    private  final PlaceDeleteService placeDeleteService;
    private final PlaceUpdateService placeUpdateService;

    public PlaceExecutorImpl(PlaceCreateService placeCreateService, PlaceGetService placeGetService, PlaceDeleteService placeDeleteService, PlaceUpdateService placeUpdateService) {
        this.placeCreateService = placeCreateService;
        this.placeGetService = placeGetService;
        this.placeDeleteService = placeDeleteService;
        this.placeUpdateService = placeUpdateService;
    }

    @Override
    public void createPlace(PlaceCreateRequest placeCreateRequest) {
        placeCreateService.createPlace(placeCreateRequest);
    }

    @Override
    public PlaceGetResponse getPlaceById(Long id) {

        PlaceGetResponseMapper placeMapper = placeGetService.getPlaceById(id);
        return PlaceGetResponse.builder()
                .placeName(placeMapper.getPlaceName())
                .country(placeMapper.getCountry())
                .lat(placeMapper.getLat())
                .lon(placeMapper.getLon())
                .type(placeMapper.getType())
                .build();
    }

    @Override
    public void deletePlace(Long id) {
        placeDeleteService.deletePlace(id);
    }

    @Override
    public void updatePlace(PlaceEditRequest placeEditRequest, Long id) {
        placeUpdateService.updatePlace(placeEditRequest,id);
    }
}
