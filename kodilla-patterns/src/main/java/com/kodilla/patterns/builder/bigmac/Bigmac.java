package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.bigmac.options.Ingredient;
import com.kodilla.patterns.builder.bigmac.options.Roll;
import com.kodilla.patterns.builder.bigmac.options.Sauce;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final Roll roll;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredient> ingredients;

    public static class BigMacBuilder {
        private Roll roll;
        private int burgers;
        private  Sauce sauce;
        private  List<Ingredient> ingredients = new ArrayList<>();

        public BigMacBuilder roll(Roll roll) {
            this.roll = roll;
            return this;
        }

        public BigMacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigMacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigMacBuilder ingredient(Ingredient ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(roll, burgers, sauce, ingredients);
        }
    }

    public Bigmac(final Roll roll, final int burgers, final Sauce sauce, final List<Ingredient> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public Roll getRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
