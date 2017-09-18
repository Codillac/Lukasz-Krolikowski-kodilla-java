package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    private final List<Continent> continents = new ArrayList<>();

    public BigDecimal getPeopleQuantity(){
        BigDecimal peopleQuantity;
        peopleQuantity = continents.stream()
                .flatMap(continent -> continent.getCountriesOnContinent().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return peopleQuantity;
    }

    public void addContinent(Continent continent){
        continents.add(continent);
    }
}
