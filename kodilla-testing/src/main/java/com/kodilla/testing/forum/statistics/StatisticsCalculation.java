package com.kodilla.testing.forum.statistics;

public class StatisticsCalculation {
    Integer numberOfUsers;
    Integer numberOfPosts;
    Integer numberOfComments;
    Double avgNumberOfPostsPerUser;
    Double avgNumberOfCommentsPerUser;
    Double avgNumberOfCommentsPerPost;

    public boolean calculateAdvStatistics(Statistics statistics){
        numberOfUsers = statistics.userNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();

        if(numberOfUsers != 0){
            avgNumberOfPostsPerUser = (double) numberOfPosts / (double) numberOfUsers;
            avgNumberOfCommentsPerUser = (double) numberOfComments / (double) numberOfUsers;
        } else {
            return false;
        }

        if(numberOfPosts != 0){
            avgNumberOfCommentsPerPost = (double) numberOfComments / (double) numberOfPosts;
        } else {
            return false;
        }
        return true;
    }

    public void showStatistics(){
        System.out.println("Average number of Posts per User: " + avgNumberOfPostsPerUser);
        System.out.println("Average number of Comments per User: " + avgNumberOfCommentsPerUser);
        System.out.println("Average number of Comments per Post: " + avgNumberOfCommentsPerPost);
    }
}
