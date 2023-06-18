package com.lukaroncevic.flightsapp.services;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.referencedata.Locations;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import com.lukaroncevic.flightsapp.dto.FlightSearchResultDto;
import com.lukaroncevic.flightsapp.mappers.FlightOffersSearchFlightSearchResultDtoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AmadeusService {

    Logger logger = LoggerFactory.getLogger(AmadeusService.class);

    @Autowired
    private Amadeus amadeus;

    @Autowired
    private FlightOffersSearchFlightSearchResultDtoMapper flightSearchResultDtoMapper;

    public List<Location> searchAirports(String keyword) {

        try{

            Params param = Params.with("subType", Locations.AIRPORT).and("keyword", keyword);

            return Arrays.asList(amadeus.referenceData.locations
                    .get(param));

        } catch (Exception e){

            logger.error("Search airports error", e);

            return Collections.emptyList();
        }

    }

    public List<FlightSearchResultDto> searchFlights(String originLocationCode, String destinationLocationCode, LocalDate departureDate,
                                        LocalDate returnDate, Integer adults){

        try{

            Params params = Params.with("originLocationCode", originLocationCode)
                    .and("destinationLocationCode", destinationLocationCode)
                    .and("departureDate", departureDate.toString())
                    .and("adults", adults)
                    .and("nonStop", true)
                    .and("max", 5);

            if(returnDate != null){
                params.and("returnDate", returnDate.toString());
            }

            List<FlightOfferSearch> flightOfferSearchList = Arrays.asList(amadeus.shopping.flightOffersSearch.get(params));

            List<FlightSearchResultDto> flightSearchResultDtoList = flightOfferSearchList.stream()
                    .map(flightOfferSearch -> flightSearchResultDtoMapper.map(flightOfferSearch))
                    .toList();

            return flightSearchResultDtoList;

        }catch (Exception e){
            logger.error("Search flight error", e);

            return Collections.emptyList();
        }

    }
}
