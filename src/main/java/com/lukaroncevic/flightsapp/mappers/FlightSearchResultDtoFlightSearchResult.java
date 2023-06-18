package com.lukaroncevic.flightsapp.mappers;

import com.lukaroncevic.flightsapp.dto.FlightSearchResultDto;
import com.lukaroncevic.flightsapp.model.FlightSearchResult;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FlightSearchResultDtoFlightSearchResult {

    public FlightSearchResult map(FlightSearchResultDto flightSearchResultDto){

        if(flightSearchResultDto == null){
            return null;
        }

        FlightSearchResult flightSearchResult = new FlightSearchResult();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(flightSearchResultDto, flightSearchResult);

        return flightSearchResult;
    }
}
