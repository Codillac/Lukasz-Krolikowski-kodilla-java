package com.kodilla.good.patterns.challenges.airtransportcompany.searchengine;

import com.kodilla.good.patterns.challenges.airtransportcompany.repository.Flight;

import java.util.Set;

public final class SearchResult {

    private final Set<Flight> setOfResults;

    public SearchResult(Set<Flight> setOfResults) {
        this.setOfResults = setOfResults;
    }

    public void showSearchResult() {

        setOfResults.stream()
                .map(flight -> flight.getFrom() + " -> " + flight.getTo())
                .forEach(System.out::println);
    }
}
