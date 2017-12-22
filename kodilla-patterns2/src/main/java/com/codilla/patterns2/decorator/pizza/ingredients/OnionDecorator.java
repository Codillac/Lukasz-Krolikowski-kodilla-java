package com.codilla.patterns2.decorator.pizza.ingredients;

import com.codilla.patterns2.decorator.pizza.AbstractPizzaDecorator;
import com.codilla.patterns2.decorator.pizza.PizzaOrder;

import java.math.BigDecimal;
import java.math.MathContext;

public class OnionDecorator extends AbstractPizzaDecorator {
    public OnionDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(0.5, new MathContext(2)));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", onion";
    }
}