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

        if(numberOfUsers != 0){
            avgNumberOfPostsPerUser = (double) numberOfPosts / (double) numberOfUsers;
            avgNumberOfCommentsPerUser = (double) numberOfComments / (double) numberOfUsers;
        } else {
            avgNumberOfPostsPerUser = null;
            avgNumberOfCommentsPerUser = null;
        }

        if(numberOfPosts != 0){
            avgNumberOfCommentsPerPost = (double) numberOfComments / (double) numberOfPosts;
        } else {
            avgNumberOfCommentsPerPost = null;
        }

    }

    public void showStatistics(){
        // does nothing
    }
}
