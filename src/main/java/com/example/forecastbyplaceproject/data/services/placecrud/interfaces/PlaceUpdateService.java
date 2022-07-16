package com.example.forecastbyplaceproject.data.services.placecrud.interfaces;

import com.example.forecastbyplaceproject.api.models.placecrud.PlaceEditRequest;

public interface PlaceUpdateService {

    void updatePlace(PlaceEditRequest placeEditRequest, Long id);

}
