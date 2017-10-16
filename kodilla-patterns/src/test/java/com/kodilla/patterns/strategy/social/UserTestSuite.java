package com.kodilla.patterns.strategy.social;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @After
    public void endLine() {
        System.out.println();
    }

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User luke = new Millenials("Luke Rabbit");
        User jonathan = new YGeneration("Jonathan Business");
        User brian = new ZGeneration("Brian Newborn");

        //When
        String lukePublisherName = luke.sharePost();
        String jonathanPublisherName = jonathan.sharePost();
        String brianPublisherName =  brian.sharePost();

        //Then
        Assert.assertEquals("Facebook", lukePublisherName);
        Assert.assertEquals("Twitter", jonathanPublisherName);
        Assert.assertEquals("Snapchat", brianPublisherName);

    }

    @Test
    public void testIndividualSharingStratefy() {
        //Given
        User grace = new YGeneration("Grace Trace");

        //When
        String graceDefaultPost = grace.sharePost();
        grace.setSocialPublisher(new SnapchatPublisher());
        String gracePostAfterChangeOfPublisher = grace.sharePost();

        //Then
        Assert.assertEquals("Twitter", graceDefaultPost);
        Assert.assertEquals("Snapchat", gracePostAfterChangeOfPublisher);
    }
}
