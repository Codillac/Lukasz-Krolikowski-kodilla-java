package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args){
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyIWillThrowException(1.0, 1.5);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Holly crap, something was messed up: " + e);
        } finally {
            System.out.println("Finally it's happen to me, right in front of my face...");
        }
    }
}
