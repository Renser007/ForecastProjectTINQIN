package com.example.startingproject.domain.interfaces;

import com.example.startingproject.domain.models.Coordinates;
import com.example.startingproject.domain.requests.LocationRequest;

import java.util.List;

public interface LocationService {

    void addLocation(String label, Coordinates coordinates);
    Coordinates getLocationCoordinates(String label);
    List<LocationRequest> getAllLocations();

}
