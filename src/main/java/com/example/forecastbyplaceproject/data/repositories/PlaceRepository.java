package com.example.forecastbyplaceproject.data.repositories;

import com.example.forecastbyplaceproject.data.entities.Country;
import com.example.forecastbyplaceproject.data.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByCountryAndPlaceName(Country country, String placeName);
}
