package com.example.forecastbyplaceproject.domain.services.placecrud;

import com.example.forecastbyplaceproject.api.models.placecrud.PlaceCreateRequest;
import com.example.forecastbyplaceproject.data.entities.Country;
import com.example.forecastbyplaceproject.data.entities.Place;
import com.example.forecastbyplaceproject.data.entities.Type;
import com.example.forecastbyplaceproject.data.repositories.CountryRepository;
import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.data.repositories.TypeRepository;
import com.example.forecastbyplaceproject.domain.services.placecrud.interfaces.PlaceCreateService;
import org.springframework.stereotype.Service;

@Service
public class PlaceCreateServiceImpl implements PlaceCreateService {

    private final CountryRepository countryRepository;
    private final PlaceRepository placeRepository;
    private final TypeRepository typeRepository;

    public PlaceCreateServiceImpl(CountryRepository countryRepository, PlaceRepository placeRepository, TypeRepository typeRepository) {
        this.countryRepository = countryRepository;
        this.placeRepository = placeRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public void createPlace(PlaceCreateRequest placeCreateRequest) {

        if (countryRepository.getCountriesByCountryName(placeCreateRequest.getCountry())==null){
            Country newCountry = new Country(placeCreateRequest.getCountry());
            countryRepository.save(newCountry);
        }
        if (typeRepository.getByTypeName(placeCreateRequest.getType())==null){
            Type newType = new Type(placeCreateRequest.getType());
            typeRepository.save(newType);
        }

        Country addedCountry = countryRepository.getCountriesByCountryName(placeCreateRequest.getCountry());
        Type addedType = typeRepository.getByTypeName(placeCreateRequest.getType());
        Place newPlace = new Place(placeCreateRequest.getName(), addedCountry, placeCreateRequest.getLat(), placeCreateRequest.getLon(), addedType);

        placeRepository.save(newPlace);
    }
}
