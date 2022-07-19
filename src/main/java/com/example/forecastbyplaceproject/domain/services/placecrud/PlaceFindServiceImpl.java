package com.example.forecastbyplaceproject.domain.services.placecrud;

import com.example.forecastbyplaceproject.data.entities.mappers.PlaceGetResponseMapper;
import com.example.forecastbyplaceproject.data.repositories.PlaceRepository;
import com.example.forecastbyplaceproject.domain.services.placecrud.interfaces.PlaceFindService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceFindServiceImpl implements PlaceFindService {

    private final PlaceRepository placeRepository;

    public PlaceFindServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public List<PlaceGetResponseMapper> findPlaceByName(String placeName) {
        return placeRepository.findAll()
                .stream()
                .filter(p1 -> p1.getPlaceName().equals(placeName))
                .map(p -> PlaceGetResponseMapper.builder()
                        .placeName(p.getPlaceName())
                        .country(p.getCountry().getCountryName())
                        .lat(p.getLat())
                        .lon(p.getLon())
                        .type(p.getType().getTypeName())
                        .build())
                .sorted(Comparator.comparing(PlaceGetResponseMapper::getPlaceName).thenComparing(PlaceGetResponseMapper::getCountry))
                .collect(Collectors.toList());
    }
}
