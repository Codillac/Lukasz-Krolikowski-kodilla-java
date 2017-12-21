package com.codilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(15);
    }

    @Override
    public String getIngredients() {
        return "dough, cheese, tomato sauce";
    }
}
