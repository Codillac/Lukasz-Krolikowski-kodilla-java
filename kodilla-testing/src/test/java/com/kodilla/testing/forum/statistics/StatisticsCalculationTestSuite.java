//package com.kodilla.testing.forum.statistics;
//
//import org.junit.Assert;
//import org.junit.Test;
//import java.util.*;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//public class StatisticsCalculationTestSuite {
//    @Test
//    public void testCalculateAdvStatisticsNoPosts(){
//        //Given
//        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();
//        Statistics statisticsMock = mock(Statistics.class);
//        List<String> theList = new ArrayList<String>();
//        for(int i = 0; i < 100; i++){
//            theList.add(Integer.toString(i));
//        }
//        when(statisticsMock.userNames()).thenReturn(theList);
//        when(statisticsMock.commentsCount()).thenReturn(100);
//        statisticsCalculation.calculateAdvStatistics(statisticsMock);
//
//        //When
//        boolean result = statisticsCalculation.calculateAdvStatistics(statisticsMock);
//
//        //Then
//        Assert.assertFalse(result);
//    }
//
//    @Test
//    public void testCalculateAdvStatisticsOneThousandPosts(){
//        //Given
//        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();
//        Statistics statisticsMock = mock(Statistics.class);
//        List<String> theList = new ArrayList<String>();
//        for(int i = 0; i < 100; i++){
//            theList.add(Integer.toString(i));
//        }
//        when(statisticsMock.userNames()).thenReturn(theList);
//        when(statisticsMock.postsCount()).thenReturn(1000);
//        when(statisticsMock.commentsCount()).thenReturn(100);
//        statisticsCalculation.calculateAdvStatistics(statisticsMock);
//
//        //When
//        Double result1 = statisticsCalculation.avgNumberOfPostsPerUser;
//        Double result2 = statisticsCalculation.avgNumberOfCommentsPerPost;
//
//        //Then
//        Assert.assertEquals(10, result1, 0);
//        Assert.assertEquals(0.1, result2, 0);
//    }
//
//    @Test
//    public void testCalculateAdvStatisticsNoComments(){
//        //Given
//        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();
//        Statistics statisticsMock = mock(Statistics.class);
//        List<String> theList = new ArrayList<String>();
//        for(int i = 0; i < 10; i++){
//            theList.add(Integer.toString(i));
//        }
//        when(statisticsMock.userNames()).thenReturn(theList);
//        when(statisticsMock.postsCount()).thenReturn(100);
//        statisticsCalculation.calculateAdvStatistics(statisticsMock);
//
//        //When
//        Double result1 = statisticsCalculation.avgNumberOfCommentsPerPost;
//        Double result2 = statisticsCalculation.avgNumberOfCommentsPerUser;
//
//        //Then
//        Assert.assertEquals(0, result1, 0);
//        Assert.assertEquals(0, result2, 0);
//    }
//
//    @Test
//    public void testCalculateAdvStatisticsMorePostsThanComments(){
//        //Given
//        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();
//        Statistics statisticsMock = mock(Statistics.class);
//        List<String> userNamesList = new ArrayList<String>();
//        userNamesList.add("John Smith");
//        when(statisticsMock.postsCount()).thenReturn(500);
//        when(statisticsMock.commentsCount()).thenReturn(150);
//        when(statisticsMock.userNames()).thenReturn(userNamesList);
//        statisticsCalculation.calculateAdvStatistics(statisticsMock);
//
//        //When
//        Double result = statisticsCalculation.avgNumberOfCommentsPerPost;
//
//        //Then
//        Assert.assertTrue(result < 1 && result > 0);
//    }
//
//    @Test
//    public void testCalculateAdvStatisticsMoreCommentsThanPosts(){
//        //Given
//        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();
//        Statistics statisticsMock = mock(Statistics.class);
//        List<String> userNamesList = new ArrayList<String>();
//        userNamesList.add("John Smith");
//        when(statisticsMock.postsCount()).thenReturn(150);
//        when(statisticsMock.commentsCount()).thenReturn(500);
//        when(statisticsMock.userNames()).thenReturn(userNamesList);
//        statisticsCalculation.calculateAdvStatistics(statisticsMock);
//
//        //When
//        Double result = statisticsCalculation.avgNumberOfCommentsPerPost;
//        //Then
//        Assert.assertTrue(result > 1);
//
//    }
//
//    @Test
//    public void testCalculateAdvStatisticsNoUsers(){
//        //Given
//        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();
//        Statistics statisticsMock = mock(Statistics.class);
//        when(statisticsMock.postsCount()).thenReturn(100);
//        when(statisticsMock.commentsCount()).thenReturn(100);
//        statisticsCalculation.calculateAdvStatistics(statisticsMock);
//
//        //When
//        boolean result = statisticsCalculation.calculateAdvStatistics(statisticsMock);
//
//        //Then
//        Assert.assertFalse(result);
//    }
//
//    @Test
//    public void testCalculateAdvStatisticsOneHundredUsers(){
//        //Given
//        StatisticsCalculation statisticsCalculation = new StatisticsCalculation();
//        Statistics statisticsMock = mock(Statistics.class);
//        List<String> theList = new ArrayList<String>();
//        for(int i = 0; i < 100; i++){
//            theList.add(Integer.toString(i));
//        }
//        when(statisticsMock.userNames()).thenReturn(theList);
//        when(statisticsMock.postsCount()).thenReturn(1000);
//        when(statisticsMock.commentsCount()).thenReturn(10);
//        statisticsCalculation.calculateAdvStatistics(statisticsMock);
//
//        //When
//        double result1 = statisticsCalculation.avgNumberOfPostsPerUser;
//        double result2 = statisticsCalculation.avgNumberOfCommentsPerUser;
//
//        //Then
//        Assert.assertEquals(10, result1, 0);
//        Assert.assertEquals(0.1, result2, 0);
//    }
//}
