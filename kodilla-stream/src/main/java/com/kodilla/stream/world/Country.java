package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {
    private final String countryName;
    private final BigDecimal citizensNumber;

    public Country(final String countryName, final BigDecimal citizensNumber) {
        this.countryName = countryName;
        this.citizensNumber = citizensNumber;
    }

    public String getCountryName() {
        return countryName;
    }

    BigDecimal getPeopleQuantity(){
        return citizensNumber;
    }
}
