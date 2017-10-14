package com.kodilla.patterns.builder.bigmac.options;

public enum Sauce {
    STANDARD ("Standard"),
    THOUSAND_ISLANDS ("1000 Islands"),
    BARBECUE ("Barbecue");

    private String option;

    Sauce(String option) {
        this.option = option;
    }
}
