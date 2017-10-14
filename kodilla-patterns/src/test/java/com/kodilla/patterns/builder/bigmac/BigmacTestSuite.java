package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.bigmac.options.Ingredient;
import com.kodilla.patterns.builder.bigmac.options.Roll;
import com.kodilla.patterns.builder.bigmac.options.Sauce;
import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigMacBuilder()
                .roll(Roll.WITH_SESAME)
                .burgers(3)
                .sauce(Sauce.BARBECUE)
                .ingredient(Ingredient.BACON)
                .ingredient(Ingredient.CUCUMBER)
                .ingredient(Ingredient.SHRIMPS)
                .build();

        //When
        int howManyBurgers = bigmac.getBurgers();
        int howManyIngredients = bigmac.getIngredients().size();
        Roll whatRoll = bigmac.getRoll();
        Sauce whatSauce = bigmac.getSauce();
        bigmac.getIngredients().stream()
                .forEach(System.out::println);

        //Then
        Assert.assertEquals(3, howManyBurgers);
        Assert.assertEquals(3, howManyIngredients);
        Assert.assertEquals(Roll.WITH_SESAME, whatRoll);
        Assert.assertEquals(Sauce.BARBECUE, whatSauce);
    }
}
