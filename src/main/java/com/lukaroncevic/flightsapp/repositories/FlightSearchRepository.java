package com.lukaroncevic.flightsapp.repositories;

import com.lukaroncevic.flightsapp.model.FlightsSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FlightSearchRepository extends JpaRepository<FlightsSearch, Integer> {

    FlightsSearch findOneByOriginLocationCodeAndDestinationLocationCodeAndDepartureDateAndReturnDateAndAdults
            (String originLocationCode, String destinationLocationCode, LocalDate departureDate, LocalDate returnDate, Integer adults);
}
