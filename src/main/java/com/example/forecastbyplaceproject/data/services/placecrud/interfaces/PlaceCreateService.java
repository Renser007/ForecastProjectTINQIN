package com.example.forecastbyplaceproject.data.services.placecrud.interfaces;

import com.example.forecastbyplaceproject.api.models.placecrud.PlaceCreateRequest;
import com.example.forecastbyplaceproject.api.models.placecrud.PlaceCreateResponse;

public interface PlaceCreateService{

    void createPlace(PlaceCreateRequest placeCreateRequest);

}
