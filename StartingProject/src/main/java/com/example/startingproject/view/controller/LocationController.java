package com.example.startingproject.view.controller;

import com.example.startingproject.domain.interfaces.LocationService;
import com.example.startingproject.domain.models.Coordinates;
import com.example.startingproject.domain.requests.LocationRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/addlocation")
    public void addLocationToMap(@RequestBody LocationRequest locationRequest){
        locationService.addLocation(locationRequest.getLabel(), Coordinates.builder()
                .x(locationRequest.getLon())
                .y(locationRequest.getLan())
                .build());
    }

    @GetMapping("/getAllLocations")
    public List<LocationRequest> getAllLocations(){
        List<LocationRequest> existingLocations = locationService.getAllLocations();
        return existingLocations;
    }
}
