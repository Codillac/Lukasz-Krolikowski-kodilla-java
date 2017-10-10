package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class LoggerTestSuite {
    @Test
    public void loggerTest() {
        //Given
        String dateAndTimeOfLogEntry = LocalDate.now() + " " + LocalTime.now();

        //When
        Logger.getInstance().log("Add file. " + dateAndTimeOfLogEntry);

        //Then
        Assert.assertEquals("Add file. " + dateAndTimeOfLogEntry, Logger.getInstance().getLastLog());
    }
}
