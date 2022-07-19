package com.example.forecastbyplaceproject.domain.interfaces;

import com.example.forecastbyplaceproject.api.models.placecrud.*;

import java.util.List;

public interface PlaceExecutor {

    void createPlace(PlaceCreateRequest placeCreateRequest);

    PlaceGetResponse getPlaceById(Long id);

    void deletePlace(Long id);

    void updatePlace(PlaceEditRequest placeEditRequest, Long id);

    List<PlaceFindResponse> findPlacesWithCorrectName(String placeName);


}
