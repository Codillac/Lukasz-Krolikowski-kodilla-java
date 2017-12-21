package com.codilla.patterns2.decorator.pizza.ingredients;

import com.codilla.patterns2.decorator.pizza.AbstractPizzaDecorator;
import com.codilla.patterns2.decorator.pizza.PizzaOrder;

import java.math.BigDecimal;

public class MozarellaDecorator extends AbstractPizzaDecorator {
    public MozarellaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(2));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", mozarella";
    }
}
