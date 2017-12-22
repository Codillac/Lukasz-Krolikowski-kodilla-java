package com.kodilla.hibernate.manytomany.facade;

public class SearchException extends Exception {
    public static String ERR_EMPTY_QUERY = "Query is null";
    public static String ERR_SEARCH_PROCESSOR_ERROR = "Search processor error";
    public static String ERR_NO_MATCH = "There is no match";

    public SearchException(String message) {
        super(message);
    }
}
