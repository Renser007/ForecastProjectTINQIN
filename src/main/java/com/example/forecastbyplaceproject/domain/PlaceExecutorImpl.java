package com.example.forecastbyplaceproject.domain;

import com.example.forecastbyplaceproject.api.models.placecrud.*;
import com.example.forecastbyplaceproject.data.entities.mappers.PlaceGetResponseMapper;
import com.example.forecastbyplaceproject.domain.interfaces.PlaceExecutor;
import com.example.forecastbyplaceproject.domain.services.placecrud.interfaces.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceExecutorImpl implements PlaceExecutor {

    private final PlaceCreateService placeCreateService;
    private final PlaceGetService placeGetService;
    private  final PlaceDeleteService placeDeleteService;
    private final PlaceUpdateService placeUpdateService;

    private final PlaceFindService placeFindService;

    public PlaceExecutorImpl(PlaceCreateService placeCreateService, PlaceGetService placeGetService, PlaceDeleteService placeDeleteService, PlaceUpdateService placeUpdateService, PlaceFindService placeFindService) {
        this.placeCreateService = placeCreateService;
        this.placeGetService = placeGetService;
        this.placeDeleteService = placeDeleteService;
        this.placeUpdateService = placeUpdateService;
        this.placeFindService = placeFindService;
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

    @Override
    public List<PlaceFindResponse> findPlacesWithCorrectName(String placeName) {
        return placeFindService.findPlaceByName(placeName)
                .stream()
                .map(p ->
                        PlaceFindResponse.builder()
                        .placeName(p.getPlaceName())
                        .country(p.getCountry())
                        .lat(p.getLat())
                        .lon(p.getLon())
                        .type(p.getType())
                        .build()).collect(Collectors.toList());
    }
}
