package com.codilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.Queue;

public class StudentTasksQueue implements Observable {
    private final String username;
    private final Queue<String> tasks = new ArrayDeque<>();
    private Observer mentor;

    public StudentTasksQueue(String username, Observer mentor) {
        this.username = username;
        this.mentor = mentor;
    }

    public void submitTask(String linkToTask) {
        tasks.offer(linkToTask);
        notifyMentor(linkToTask);
    }

    @Override
    public void notifyMentor(String linkToTask) {
        mentor.notifyAboutTheSubmittedTask(this, linkToTask);
    }

    @Override
    public void assignMentor(Observer mentor) {
        this.mentor = mentor;
    }

    public String getUsername() {
        return username;
    }

    public Queue<String> getTasks() {
        return tasks;
    }

    public Observer getMentor() {
        return mentor;
    }
}
