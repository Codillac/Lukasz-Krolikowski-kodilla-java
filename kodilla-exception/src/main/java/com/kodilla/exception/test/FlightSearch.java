package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {
    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Heathrow", true);
        airports.put("LaGuardia", true);
        airports.put("JFK", false);
        airports.put("Tegel", false);
        airports.put("Shonefeld", true);
        airports.put("Chopina", true);
        airports.put("Modlin", false);

        try {
            boolean airportOneAvailability = airports.get(flight.getDepartureAirport());
            boolean airportTwoAvailability = airports.get(flight.getArrivalAirport());

            if(airportOneAvailability && airportTwoAvailability){
                System.out.println("Flight From: " + flight.getDepartureAirport() + " To: " + flight.getArrivalAirport() + " is available NOW");
            } else {
                System.out.println("Flight From: " + flight.getDepartureAirport() + " To: " + flight.getArrivalAirport() + " is NOT available NOW");
            }
        } catch (Exception e) {
            throw new RouteNotFoundException("Route not found!");
        }



    }

    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();
        Flight flight = new Flight("Auckland", "Chopina");

        try {
            flightSearch.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println(e);
        }
    }
}
