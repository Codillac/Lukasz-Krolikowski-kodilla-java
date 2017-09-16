package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUsersList = new ArrayList<>();
    public Forum(){
        forumUsersList.add(new ForumUser(1001, "Bertrand Russel", 'M', LocalDate.of(1872, 5, 18), 0));
        forumUsersList.add(new ForumUser(1002, "Edsger Dijkstra", 'M', LocalDate.of(1930, 5, 11), 1394));
        forumUsersList.add(new ForumUser(1003, "Grace Hopper", 'F', LocalDate.of(1906, 12, 9), 27));
        forumUsersList.add(new ForumUser(1004, "Arthur Intelligent", 'M', LocalDate.of(2015, 1, 1), 256));
        forumUsersList.add(new ForumUser(1005, "Artifia Intelligent", 'F', LocalDate.of(1997, 6, 8), 1024));
        forumUsersList.add(new ForumUser(1006, "Linus Torvalds", 'M', LocalDate.of(1969, 12, 28), 666));
        forumUsersList.add(new ForumUser(1007, "Elon Musk", 'M', LocalDate.of(1971, 6, 28), 31415));
        forumUsersList.add(new ForumUser(1008, "Tyrion Lannister", 'M', LocalDate.of(2002, 9, 17), 300));
        forumUsersList.add(new ForumUser(1009, "Daenerys Targaryen", 'F', LocalDate.of(2001, 11, 3), 1));
        forumUsersList.add(new ForumUser(1010, "Bjarne Stroustrup", 'M', LocalDate.of(1950, 6, 8), 1));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList(forumUsersList);
    }
}
