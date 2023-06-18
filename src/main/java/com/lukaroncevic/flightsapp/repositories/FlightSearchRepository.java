package com.lukaroncevic.flightsapp.repositories;

import com.lukaroncevic.flightsapp.model.FlightsSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightSearchRepository extends JpaRepository<FlightsSearch, Integer> {
}
