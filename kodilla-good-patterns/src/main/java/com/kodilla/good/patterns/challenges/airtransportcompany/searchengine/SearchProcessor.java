package com.kodilla.good.patterns.challenges.airtransportcompany.searchengine;

import com.kodilla.good.patterns.challenges.airtransportcompany.repository.Flight;
import com.kodilla.good.patterns.challenges.airtransportcompany.repository.FlightsRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchProcessor {

    private FlightsRepository flightsRepository;
    private final int PAIR_CONDITION = 2;

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

    public Set<Flight> searchFromToViaPlace(String from, String to, String via) {

        Set<Flight> searchResult = flightsRepository.getFlights().stream()
                .filter(f -> (f.getFrom() == from && f.getTo() == via) || (f.getFrom() == via && f.getTo() == to))
                .collect(Collectors.toSet());

        if (searchResult.size() != PAIR_CONDITION) {
            searchResult.clear();
        }

        return searchResult;
    }

    public Set<Flight> searchAlsoWithChangeOver(String from, String to) {

        Set<Flight> searchResult = new HashSet<>();

        flightsRepository.getFlights().stream()
                .filter(flight -> flight.getFrom() == from)
                .forEach(flight -> {
                    if (flight.getTo() == to) {
                        searchResult.add(flight);
                    } else {
                        flightsRepository.getFlights().stream()
                                .filter(flight1 -> flight1 != flight)
                                .filter(flight1 -> flight1.getFrom() == flight.getTo())
                                .filter(flight1 -> flight1.getTo() == to)
                                .forEach(flight1 -> {
                                    searchResult.add(flight1);
                                    searchResult.add(flight);
                                });
                    }

                });
        return searchResult;
    }
}