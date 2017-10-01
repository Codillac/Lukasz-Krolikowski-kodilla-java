package com.kodilla.good.patterns.challenges.airtransportcompany;

import com.kodilla.good.patterns.challenges.airtransportcompany.repository.FlightsRepository;
import com.kodilla.good.patterns.challenges.airtransportcompany.searchengine.SearchProcessor;
import com.kodilla.good.patterns.challenges.airtransportcompany.searchengine.SearchResult;

public class AirTransportCompanyApplication {

    public static void main(String[] arg) {

        FlightsRepository flightsRepository = new FlightsRepository();
        SearchProcessor searchProcessor = new SearchProcessor(flightsRepository);

        SearchResult searchResult1 = new SearchResult(searchProcessor.searchAllFromPlace("WROCŁAW"));
        SearchResult searchResult2 = new SearchResult(searchProcessor.searchAllToPlace("WROCŁAW"));
        SearchResult searchResult3 = new SearchResult(searchProcessor.searchFromToViaPlace("WROCŁAW", "WARSZAWA", "GDAŃSK"));

        searchResult1.showSearchResult();
        System.out.println();
        searchResult2.showSearchResult();
        System.out.println();
        searchResult3.showSearchResult();

        System.out.println();

        SearchResult searchResult4 = new SearchResult(searchProcessor.searchAlsoWithChangeOver("WROCŁAW", "WARSZAWA"));
        searchResult4.showSearchResult();
    }
}
