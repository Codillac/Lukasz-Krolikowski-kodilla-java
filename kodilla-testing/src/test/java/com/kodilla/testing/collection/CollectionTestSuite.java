package com.kodilla.testing.collection;

import org.junit.*;
import java.util.*;

public class CollectionTestSuite {
    static int counter = 1;

    @Before
    public void before(){
        System.out.println("Now... Test Case " + counter + " begins");
    }

    @After
    public void after() {
        System.out.println("Now... Test Case " + counter + " ends");
        counter++;
    }

    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        numbers = oddNumbersExterminator.exterminate(numbers);
        //Then
        for(Integer currentNumber : numbers){
            Assert.assertFalse(currentNumber % 2 != 0);
        }

    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < 100; i++) {
            numbers.add(i + 1);
        }
        Random random = new Random();
        for(int i = 0; i < 100000; i++) {
            numbers.add(random.nextInt(1000) + 1);
        }

        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        //When
        numbers = oddNumbersExterminator.exterminate(numbers);
        //Then
        for(Integer currentNumber : numbers){
            Assert.assertFalse(currentNumber % 2 != 0);
        }

    }
}