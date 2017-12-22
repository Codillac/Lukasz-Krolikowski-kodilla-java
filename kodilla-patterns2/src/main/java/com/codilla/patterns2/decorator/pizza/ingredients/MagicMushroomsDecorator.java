package com.codilla.patterns2.decorator.pizza.ingredients;

import com.codilla.patterns2.decorator.pizza.AbstractPizzaDecorator;
import com.codilla.patterns2.decorator.pizza.PizzaOrder;

import java.math.BigDecimal;
import java.math.MathContext;

public class MagicMushroomsDecorator extends AbstractPizzaDecorator {
    public MagicMushroomsDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(5.45, new MathContext(3)));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", magic mushrooms";
    }
}
