package com.lukaroncevic.flightsapp.services;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.referencedata.Locations;
import com.amadeus.resources.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AmadeusService {

    @Autowired
    private Amadeus amadeus;

    public List<Location> getLocation(String keyword) throws ResponseException {

        return Arrays.asList(amadeus.referenceData.locations
                .get(Params.with("subType", Locations.AIRPORT).and("keyword", keyword)));

    }
}
