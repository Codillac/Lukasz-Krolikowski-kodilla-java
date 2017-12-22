package com.codilla.patterns2.decorator.pizza;

import com.codilla.patterns2.decorator.pizza.ingredients.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

public class PizzaOrderTestSuite {
    @Test
    public void testPizzaOrderWithAllPossibleIngredientsGetPrice() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MozarellaDecorator(pizzaOrder);
        pizzaOrder = new ChickenWithCurryDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new GoatCheeseDecorator(pizzaOrder);
        pizzaOrder = new FetaCheeseDecorator(pizzaOrder);
        pizzaOrder = new MagicMushroomsDecorator(pizzaOrder);

        //When
        BigDecimal price = pizzaOrder.getPrice();
        System.out.println(price);

        //Then
        Assert.assertEquals(new BigDecimal(33.20, new MathContext(4)), price);
    }

    @Test
    public void testPizzaOrderWithAllPossibleIngredientsGetIngredients() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MozarellaDecorator(pizzaOrder);
        pizzaOrder = new ChickenWithCurryDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new GoatCheeseDecorator(pizzaOrder);
        pizzaOrder = new FetaCheeseDecorator(pizzaOrder);
        pizzaOrder = new MagicMushroomsDecorator(pizzaOrder);

        //When
        String ingredients = pizzaOrder.getIngredients();
        System.out.println(ingredients);

        //Then
        Assert.assertEquals("dough, cheese, tomato sauce, mozarella, small pieces of chicken with curry, onion, goat cheese, feta cheese, magic mushrooms", ingredients);
    }

    @Test
    public void testPizzaOrderQuatroFromaggiWihtDoubleMozarellaGetPrice() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new GoatCheeseDecorator(pizzaOrder);
        pizzaOrder = new FetaCheeseDecorator(pizzaOrder);
        pizzaOrder = new MozarellaDecorator(pizzaOrder);
        pizzaOrder = new MozarellaDecorator(pizzaOrder);

        //When
        BigDecimal price = pizzaOrder.getPrice();
        System.out.println(price);

        //Then
        Assert.assertEquals(new BigDecimal(25), price.round(new MathContext(2)));
    }

    @Test
    public void testPizzaOrderQuatroFromaggiWihtDoubleMozarellaGetIngredients() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new GoatCheeseDecorator(pizzaOrder);
        pizzaOrder = new FetaCheeseDecorator(pizzaOrder);
        pizzaOrder = new MozarellaDecorator(pizzaOrder);
        pizzaOrder = new MozarellaDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getIngredients();
        System.out.println(description);

        //Then
        Assert.assertEquals("dough, cheese, tomato sauce, goat cheese, feta cheese, mozarella, mozarella", description);
    }
}
