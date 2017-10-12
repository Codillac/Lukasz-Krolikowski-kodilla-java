package com.kodilla.patterns.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger loggerInstance = null;
    private String lastLog = "";

    private Logger() {
    }

    public static Logger getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    public String log(String log) {
        String loggedDateAndTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        lastLog = log + loggedDateAndTime;
        System.out.println(lastLog);
        return loggedDateAndTime;
    }

    public String getLastLog() {
        return lastLog;
    }
}