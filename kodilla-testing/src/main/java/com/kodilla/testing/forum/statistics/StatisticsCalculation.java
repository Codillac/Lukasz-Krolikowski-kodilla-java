package com.kodilla.testing.forum.statistics;

public class StatisticsCalculation {
    Integer numberOfUsers;
    Integer numberOfPosts;
    Integer numberOfComments;
    Double avgNumberOfPostsPerUser;
    Double avgNumberOfCommentsPerUser;
    Double avgNumberOfCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics){
        numberOfUsers = statistics.userNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();

            avgNumberOfPostsPerUser = (double) numberOfPosts / (double) numberOfUsers;
            avgNumberOfCommentsPerUser = (double) numberOfComments / (double) numberOfUsers;
            avgNumberOfCommentsPerPost = (double) numberOfComments / (double) numberOfPosts;
    }

    public void showStatistics(){
        System.out.println("Average number of Posts per User: " + avgNumberOfPostsPerUser);
        System.out.println("Average number of Comments per User: " + avgNumberOfCommentsPerUser);
        System.out.println("Average number of Comments per Post: " + avgNumberOfCommentsPerPost);
    }
}
