package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        World parallelWorld = new World();
        Continent continent1 = new Continent("Europe");
        Continent continent2 = new Continent("Asia");
        Continent continent3 = new Continent("Atlantis");
        parallelWorld.addContinent(continent1);
        parallelWorld.addContinent(continent2);
        parallelWorld.addContinent(continent3);
        continent1.addCountry(new Country("Poland", new BigDecimal("38432992")));
        continent1.addCountry(new Country("Germany", new BigDecimal("29812903")));
        continent1.addCountry(new Country("France", new BigDecimal("459898786")));
        continent2.addCountry(new Country("China", new BigDecimal("1403500365")));
        continent2.addCountry(new Country("India", new BigDecimal("9937263723")));
        continent2.addCountry(new Country("Russia", new BigDecimal("334400905")));
        continent2.addCountry(new Country("Japan", new BigDecimal("67989894")));
        continent3.addCountry(new Country("Arrakis", new BigDecimal("29843289723")));
        continent3.addCountry(new Country("Nilfgaard", new BigDecimal("23402384939")));
        continent3.addCountry(new Country("Brocillon", new BigDecimal("9319028301293")));

        //When
        BigDecimal numberOfPeople = parallelWorld.getPeopleQuantity();

        //Then
        Assert.assertEquals(new BigDecimal("9384545275523"), numberOfPeople);
    }
}
