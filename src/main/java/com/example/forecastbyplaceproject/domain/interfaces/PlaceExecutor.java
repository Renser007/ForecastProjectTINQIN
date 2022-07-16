package com.example.forecastbyplaceproject.domain.interfaces;

import com.example.forecastbyplaceproject.api.models.placecrud.PlaceCreateRequest;
import com.example.forecastbyplaceproject.api.models.placecrud.PlaceEditRequest;
import com.example.forecastbyplaceproject.api.models.placecrud.PlaceGetResponse;

public interface PlaceExecutor {

    void createPlace(PlaceCreateRequest placeCreateRequest);

    PlaceGetResponse getPlaceById(Long id);

    void deletePlace(Long id);

    void updatePlace(PlaceEditRequest placeEditRequest, Long id);


}
