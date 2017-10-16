package com.kodilla.patterns.builder.bigmac.options;

public enum Ingredient {
    LETTUCE ("Lettuce"),
    ONION ("Onion"),
    BACON ("Bacon"),
    CUCUMBER ("Cucumber"),
    CHILI_PEPPER ("Chili Pepper"),
    MUSHROOMS ("Mushrooms"),
    SHRIMPS ("Shrimps"),
    CHEESE ("Cheese");

    private String optionName;

    Ingredient(String optionName) {
        this.optionName = optionName;
    }
}
