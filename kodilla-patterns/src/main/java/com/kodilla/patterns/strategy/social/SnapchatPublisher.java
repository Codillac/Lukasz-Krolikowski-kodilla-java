package com.kodilla.patterns.strategy.social;

public class SnapchatPublisher implements SocialPublisher {
    private static final String publisherName = "Snapchat";

    @Override
    public String share() {
        System.out.println(publisherName);
        return publisherName;
    }
}
