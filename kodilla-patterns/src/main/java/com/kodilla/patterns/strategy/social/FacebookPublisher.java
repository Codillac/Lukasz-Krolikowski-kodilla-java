package com.kodilla.patterns.strategy.social;

public class FacebookPublisher implements SocialPublisher {
    private static final String publisherName = "Facebook";

    @Override
    public String share() {
        System.out.println(publisherName);
        return publisherName;
    }
}
