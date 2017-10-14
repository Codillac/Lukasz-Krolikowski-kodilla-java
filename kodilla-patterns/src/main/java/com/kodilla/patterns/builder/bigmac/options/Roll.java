package com.kodilla.patterns.builder.bigmac.options;

public enum Roll {
    WITH_SESAME ("With Sesame"),
    WITHOUT_SESAME ("Without Sesame");

    private String option;

    Roll(String option) {
        this.option = option;
    }
}
