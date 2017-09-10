package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

import java.util.Random;

public class TestingMain {
    public static void main(String[] args){
        // Test of class Calculator methods:
        Calculator calculator = new Calculator();
        Random randomizer = new Random();
        int a = randomizer.nextInt(1000000000) + 1;
        int b = randomizer.nextInt(1000000000) + 1;

        int addingResult = a + b;
        int subtractingResult = a - b;

        if(calculator.add(a, b) == addingResult){
            System.out.println("Adding test OK");
        } else {
            System.out.println("Adding test FAILED!");
        }

        if(calculator.subtract(a, b) == subtractingResult){
            System.out.println("Subtracting test OK");
        } else {
            System.out.println("Subtracting test FAILED!");
        }
    }
}
