package com.kodilla.good.patterns.challenges.airtransportcompany.searchengine;

import com.kodilla.good.patterns.challenges.airtransportcompany.repository.Flight;
import com.kodilla.good.patterns.challenges.airtransportcompany.repository.FlightsRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class SearchProcessor {

    private FlightsRepository flightsRepository;

    public SearchProcessor(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    public Set<Flight> searchAllFromPlace(String from) {

        Set<Flight> searchResult = flightsRepository.getFlights().stream()
                .filter(f -> f.getFrom() == from)
                .collect(Collectors.toSet());
        return searchResult;
    }

    public Set<Flight> searchAllToPlace(String to) {

        Set<Flight> searchResult = flightsRepository.getFlights().stream()
                .filter(f -> f.getTo() == to)
                .collect(Collectors.toSet());
        return searchResult;
    }

    public Set<Flight> searchViaPlace(String from, String to, String via) {

        Set<Flight> searchResult = flightsRepository.getFlights().stream()
                .filter(f -> (f.getFrom() == from && f.getTo() == via) || (f.getFrom() == via && f.getTo() == to))
                .collect(Collectors.toSet());
        return searchResult;
    }
}
