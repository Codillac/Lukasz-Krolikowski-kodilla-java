package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum theForum = new Forum();
        Map<Integer, ForumUser> resultMap = theForum.getUserList().stream()
                .filter(forumUser -> forumUser.getUserSex() == 'M')
                .filter(forumUser -> LocalDate.now().compareTo(forumUser.getUserDateOfBirth()) > 20)
                .filter(forumUser -> forumUser.getUserNumberOfPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));

         for(Map.Entry<Integer, ForumUser> entry : resultMap.entrySet()){
             System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }
}
