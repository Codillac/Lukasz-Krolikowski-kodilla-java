package com.kodilla.patterns.strategy;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTestSuite {
    @Test
    public void testDefaultInvestingStrategy() {
        //Given
        Customer steven = new IndividualCustomer("Steven Links");
        Customer john = new IndividualYoungCustomer("John Hemerald");
        Customer kodilla = new CorporateCustomer("Kodilla");

        //When
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        String johnShouldBuy = john.predict();
        System.out.println("John should: " + johnShouldBuy);
        String kodillaShouldBuy = kodilla.predict();
        System.out.println("Kodilla should: " + kodillaShouldBuy);

        //Then
        Assert.assertEquals("[ConservativePredictor] Buy debentures of XYZ", stevenShouldBuy);
        Assert.assertEquals("[AggressivePredictor] Buy stock of XYZ", johnShouldBuy);
        Assert.assertEquals("[BalancedPredictor] Buy shared units of Fund XYZ", kodillaShouldBuy);
    }

    @Test
    public void testIndividualInvestingStrategy() {
        //Given
        Customer steven = new IndividualCustomer("Steven Links");

        //When
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        steven.setBuyingStrategy(new AggressivePredictor());
        stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);

        //Then
        Assert.assertEquals("[AggressivePredictor] Buy stock of XYZ", stevenShouldBuy);
    }
}
