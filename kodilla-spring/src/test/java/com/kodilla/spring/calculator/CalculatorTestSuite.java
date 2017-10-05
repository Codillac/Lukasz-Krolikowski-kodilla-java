package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

@SpringBootApplication
public class CalculatorTestSuite {
    @Test
    public void testCalculatorAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        Random generator = new Random();
        double a = generator.nextInt(100) + generator.nextDouble();
        double b = generator.nextInt(50) + generator.nextDouble();

        //When
        double result = calculator.add(a, b);

        //Then
        Assert.assertEquals(a + b, result, 0);
    }

    @Test
    public void testCalculatorSub() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        Random generator = new Random();
        double a = generator.nextInt(200) + generator.nextDouble();
        double b = generator.nextInt(100) + generator.nextDouble();

        //When
        double result = calculator.sub(a, b);

        //Then
        Assert.assertEquals(a - b, result, 0);
    }

    @Test
    public void testCalculatorMul() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        Random generator = new Random();
        double a = generator.nextInt(100) + generator.nextDouble();
        double b = generator.nextInt(100) + generator.nextDouble();

        //When
        double result = calculator.mul(a, b);

        //Then
        Assert.assertEquals(a * b, result, 0);
    }

    @Test
    public void testCalculatorDiv() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        Random generator = new Random();
        double a = generator.nextInt(500) + generator.nextDouble();
        double b = generator.nextInt(100) + 1 + generator.nextDouble();

        //When
        double result = calculator.div(a, b);

        //Then
        Assert.assertEquals(a / b, result, 0);
    }
}
