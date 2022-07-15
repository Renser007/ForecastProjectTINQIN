package com.example.startingproject.domain.services;

import com.example.startingproject.domain.interfaces.LocationService;
import com.example.startingproject.domain.models.Coordinates;
import com.example.startingproject.domain.requests.LocationRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LocationServiceImpl implements LocationService {

    private Map<String, Coordinates> locations;

    public LocationServiceImpl() {
        this.locations = new HashMap<>();
        locations.put("Varna", Coordinates.builder()
                .x(43.204666)
                .y(27.910543)
                .build());
    }

    @Override
    public void addLocation(String label, Coordinates coordinates) {
        if (!locations.containsKey(label)) {
            locations.put(label, coordinates);
        }
    }

    @Override
    public Coordinates getLocationCoordinates(String label) {

        if (!locations.containsKey(label)){
            throw new IndexOutOfBoundsException();
        }
        return locations.get(label);
    }

    @Override
    public List<LocationRequest> getAllLocations() {
        List<LocationRequest> locationRequestList = new ArrayList<>();
        for (String s:locations.keySet()){
            LocationRequest existingLocation = LocationRequest.builder()
                    .label(s)
                    .lan(locations.get(s).getX())
                    .lon(locations.get(s).getY())
                    .build();
            locationRequestList.add(existingLocation);
        }
        return locationRequestList;
    }
}
