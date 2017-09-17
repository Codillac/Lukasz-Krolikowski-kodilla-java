package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        //Given
        //Sample data
        int[] testNumbers = {5, 12, 8, 1, 42, 19, 1, 4, 3};

        //When
        double result = ArrayOperations.getAverage(testNumbers);

        //Then
        Assert.assertEquals(10.5555, result, 0.0001);
    }
}
