package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class LoggerTestSuite {
    private static Logger logger = new Logger();

    @Test
    public void loggerTest() {
        //Given
        String dateAndTimeOfLogEntry = LocalDate.now() + " " + LocalTime.now();

        //When
        logger.log("Add file. " + dateAndTimeOfLogEntry);

        //Then
        Assert.assertEquals("Add file. " + dateAndTimeOfLogEntry, logger.getLastLog());
    }
}
