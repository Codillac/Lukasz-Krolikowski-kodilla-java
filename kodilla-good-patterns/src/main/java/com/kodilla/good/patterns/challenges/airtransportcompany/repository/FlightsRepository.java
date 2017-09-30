package com.kodilla.good.patterns.challenges.airtransportcompany.repository;

import java.util.ArrayList;
import java.util.List;

public final class FlightsRepository {

    private final List<Flight> flights = new ArrayList<>();

    public FlightsRepository() {

        flights.add(new DomesticFlight("WROCŁAW", "WARSZAWA"));
        flights.add(new DomesticFlight("WARSZAWA", "WROCŁAW"));
        flights.add(new DomesticFlight("KRAKÓW", "WARSZAWA"));
        flights.add(new DomesticFlight("WARSZAWA", "KRAKÓW"));
        flights.add(new DomesticFlight("POZNAŃ", "WARSZAWA"));
        flights.add(new DomesticFlight("WARASZAWA", "POZNAŃ"));
        flights.add(new DomesticFlight("SZCZECIN", "WARSZAWA"));
        flights.add(new DomesticFlight("WARSZAWA", "SZCZECIN"));
        flights.add(new DomesticFlight("GDAŃSK", "WARSZAWA"));
        flights.add(new DomesticFlight("WARSZAWA", "GDAŃSK"));
        flights.add(new DomesticFlight("GDAŃSK", "KRAKÓW"));
        flights.add(new DomesticFlight("KRAKÓW", "GDAŃSK"));
        flights.add(new DomesticFlight("WROCŁAW", "GDAŃSK"));
        flights.add(new DomesticFlight("GDAŃSK", "WROCŁAW"));
        flights.add(new DomesticFlight("WROCŁAW", "LUBLIN"));
    }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }
}