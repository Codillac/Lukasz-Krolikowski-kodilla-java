package com.codilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String name;
    private int numberOfTasksToCheck;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void notifyAboutTheSubmittedTask(StudentTasksQueue tasksQueue, String link) {
        System.out.println("There is a new Task submitted by: " + tasksQueue.getUsername() + ", link: " + link);
        numberOfTasksToCheck++;
    }

    public int getNumberOfTasksToCheck() {
        return numberOfTasksToCheck;
    }
}