package com.lukaroncevic.flightsapp.mappers;

import com.amadeus.resources.FlightOfferSearch;
import com.lukaroncevic.flightsapp.dto.FlightSearchResultDto;
import org.springframework.stereotype.Component;

@Component
public class FlightOffersSearchFlightSearchResultDtoMapper {

    public FlightSearchResultDto map(FlightOfferSearch flightOfferSearch){

        if(flightOfferSearch == null){
            return null;
        }

        FlightSearchResultDto flightSearchResultDto = new FlightSearchResultDto();

        FlightOfferSearch.Itinerary outboundItinerary = flightOfferSearch.getItineraries()[0];
        FlightOfferSearch.Itinerary inboundItinerary = flightOfferSearch.getItineraries()[1];

        FlightOfferSearch.SearchSegment firstOutboundSegment = outboundItinerary.getSegments()[0];
        FlightOfferSearch.SearchSegment lastOutboundSegment = outboundItinerary.getSegments()[outboundItinerary.getSegments().length -1];

        FlightOfferSearch.SearchSegment firstInboundSegment = inboundItinerary.getSegments()[0];
        FlightOfferSearch.SearchSegment lastInboundSegment = inboundItinerary.getSegments()[inboundItinerary.getSegments().length - 1];

        flightSearchResultDto.setOutboundDepartureAirport(firstOutboundSegment.getDeparture().getIataCode());
        flightSearchResultDto.setOutboundArrivalAirport(lastOutboundSegment.getArrival().getIataCode());
        flightSearchResultDto.setOutboundDepartureDate(firstOutboundSegment.getDeparture().getAt());
        flightSearchResultDto.setOutboundArrivalDate(lastOutboundSegment.getArrival().getAt());

        flightSearchResultDto.setInboundDepartureAirport(firstInboundSegment.getDeparture().getIataCode());
        flightSearchResultDto.setInboundArrivalAirport(lastInboundSegment.getArrival().getIataCode());
        flightSearchResultDto.setInboundDepartureDate(firstInboundSegment.getDeparture().getAt());
        flightSearchResultDto.setInboundArrivalDate(lastInboundSegment.getArrival().getAt());

        flightSearchResultDto.setCarrier(firstOutboundSegment.getCarrierCode());
        flightSearchResultDto.setPrice(flightOfferSearch.getPrice().getTotal());

        return flightSearchResultDto;
    }
}
