package com.example.forecastbyplaceproject.api.controllers;

import com.example.forecastbyplaceproject.api.models.placecrud.PlaceCreateRequest;
import com.example.forecastbyplaceproject.api.models.placecrud.PlaceEditRequest;
import com.example.forecastbyplaceproject.api.models.placecrud.PlaceGetResponse;
import com.example.forecastbyplaceproject.domain.interfaces.PlaceExecutor;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlacesController {

    private final PlaceExecutor placeExecutor;

    public PlacesController(PlaceExecutor placeExecutor) {
        this.placeExecutor = placeExecutor;
    }

    @PostMapping("/place")
    public void createPlace(@RequestBody PlaceCreateRequest placeCreateRequest){

        placeExecutor.createPlace(placeCreateRequest);
    }

    @PutMapping("/place/{ID}")
    public void updatePlace(@RequestBody PlaceEditRequest placeEditRequest, @PathVariable Long ID){
        placeExecutor.updatePlace(placeEditRequest, ID);
    }

    @DeleteMapping("/place")
    public void deletePlace(@RequestParam Long id){
        placeExecutor.deletePlace(id);
    }

    @GetMapping("/place{ID}")
    public PlaceGetResponse getPlaceById(@PathVariable Long ID){

        return placeExecutor.getPlaceById(ID); //po id
    }


}
