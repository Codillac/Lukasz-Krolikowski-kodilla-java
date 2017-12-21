package com.codilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public abstract class AbstractPizzaDecorator implements PizzaOrder {
    private final PizzaOrder pizzaOrder;

    protected AbstractPizzaDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public BigDecimal getPrice() {
        return pizzaOrder.getPrice();
    }

    @Override
    public String getIngredients() {
        return pizzaOrder.getIngredients();
    }
}
