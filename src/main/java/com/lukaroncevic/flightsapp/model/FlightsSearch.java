package com.lukaroncevic.flightsapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Table(name = "flights_search")
@Entity
public class FlightsSearch extends BaseEntity{

    private String originLocationCode;

    private String destinationLocationCode;

    private LocalDate departureDate;

    private LocalDate returnDate;

    private Integer adults;

    @OneToMany(mappedBy = "flightsSearch")
    private List<FlightSearchResult> flightSearchResultList;

    public String getOriginLocationCode() {
        return originLocationCode;
    }

    public void setOriginLocationCode(String originLocationCode) {
        this.originLocationCode = originLocationCode;
    }

    public String getDestinationLocationCode() {
        return destinationLocationCode;
    }

    public void setDestinationLocationCode(String destinationLocationCode) {
        this.destinationLocationCode = destinationLocationCode;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public List<FlightSearchResult> getFlightSearchResultList() {
        return flightSearchResultList;
    }

    public void setFlightSearchResultList(List<FlightSearchResult> flightSearchResultList) {
        this.flightSearchResultList = flightSearchResultList;
    }
}
