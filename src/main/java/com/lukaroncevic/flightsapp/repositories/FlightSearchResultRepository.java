package com.lukaroncevic.flightsapp.repositories;

import com.lukaroncevic.flightsapp.model.FlightSearchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSearchResultRepository extends JpaRepository<FlightSearchResult, Integer> {
}
