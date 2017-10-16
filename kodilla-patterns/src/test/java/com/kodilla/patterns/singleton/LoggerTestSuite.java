package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class LoggerTestSuite {
    @Test
    public void loggerTest() {
        //Given
        //When
        String loggedDateAndTime = Logger.getInstance().log("Add file.");

        //Then
        Assert.assertEquals("Add file." + loggedDateAndTime, Logger.getInstance().getLastLog());
    }
}
