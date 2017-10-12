package com.kodilla.patterns.strategy.social;

public class TwitterPublisher implements SocialPublisher {
    private static final String publisherName = "Twitter";

    @Override
    public String share() {
        System.out.println(publisherName);
        return publisherName;
    }
}
