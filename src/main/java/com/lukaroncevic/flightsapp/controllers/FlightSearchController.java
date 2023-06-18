package com.lukaroncevic.flightsapp.controllers;

import com.amadeus.resources.Location;
import com.lukaroncevic.flightsapp.dto.FlightSearchResultDto;
import com.lukaroncevic.flightsapp.dto.LocationDto;
import com.lukaroncevic.flightsapp.form.FlightSearchForm;
import com.lukaroncevic.flightsapp.mappers.LocationLocationDtoMapper;
import com.lukaroncevic.flightsapp.services.AmadeusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/flight-search")
public class FlightSearchController {

    @Autowired
    private AmadeusService amadeusService;

    @Autowired
    private LocationLocationDtoMapper locationLocationDtoMapper;

    @GetMapping("airports/{keyword}")
    public ResponseEntity<List<LocationDto>> searchAirports(@PathVariable String keyword){

        List<Location> locationList = amadeusService.searchAirports(keyword);

        return ResponseEntity
                .ok()
                .body(
                        amadeusService.searchAirports(keyword)
                                .stream()
                                .map(location -> locationLocationDtoMapper.map(location))
                                .toList()
                );
    }

    @PostMapping("flights")
    public ResponseEntity<List<FlightSearchResultDto>> searchFlights(@RequestBody @Valid FlightSearchForm flightSearchForm){

        List<FlightSearchResultDto> flightSearchResultDtoList = amadeusService.searchFlights(
                flightSearchForm.getOriginLocationCode(),
                flightSearchForm.getDestinationLocationCode(),
                flightSearchForm.getDepartureDate(),
                flightSearchForm.getReturnDate(),
                flightSearchForm.getAdults());

        return ResponseEntity.ok().body(flightSearchResultDtoList);
    }
}
