package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    final private String continentName;
    final private List<Country> countriesOnContinent = new ArrayList<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public void addCountry(Country country) {
        countriesOnContinent.add(country);
    }

    public List<Country> getCountriesOnContinent() {
        return new ArrayList<>(countriesOnContinent);
    }
}
