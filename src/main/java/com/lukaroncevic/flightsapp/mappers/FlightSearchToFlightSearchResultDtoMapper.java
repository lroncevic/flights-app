package com.lukaroncevic.flightsapp.mappers;

import com.lukaroncevic.flightsapp.dto.FlightSearchResultDto;
import com.lukaroncevic.flightsapp.model.FlightSearchResult;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FlightSearchToFlightSearchResultDtoMapper {

    public FlightSearchResultDto map(FlightSearchResult flightSearchResult){

        FlightSearchResultDto flightSearchResultDto = new FlightSearchResultDto();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(flightSearchResult, flightSearchResultDto);

        return flightSearchResultDto;
    }
}
