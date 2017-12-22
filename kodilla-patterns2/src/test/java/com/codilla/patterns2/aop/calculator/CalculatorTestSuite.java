package com.codilla.patterns2.aop.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorTestSuite.class);

    @Test
    public void testAdd() {
        //When
        double result = calculator.add(10,15);

        //Then
        LOGGER.info("Testing add method");
        assertEquals(25, result, 0);
    }

    @Test
    public void testSub() {
        //When
        double result = calculator.sub(25, 15);

        //Then
        LOGGER.info("Testing sub method");
        assertEquals(10, result, 0);
    }

    @Test
    public void testMul() {
        //When
        double result = calculator.mul(3, 7);

        //Then
        LOGGER.info("Testing mul method");
        assertEquals(21, result, 0);
    }

    @Test
    public void testDiv() {
        //When
        double result = calculator.div(25, 5);

        //Then
        LOGGER.info("Testing div method");
        assertEquals(5, result, 0);
    }

    @Test
    public void testFactorial() {
        //When
        BigDecimal result = calculator.factorial(new BigDecimal("1000"));

        //Then
        LOGGER.info("Testing factorial method");
        assertTrue(BigDecimal.ONE.compareTo(result) < 0);
    }
}
