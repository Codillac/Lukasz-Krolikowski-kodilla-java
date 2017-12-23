package com.codilla.patterns2.observer.homework;

public interface Observer {
    void notifyAboutTheSubmittedTask(StudentTasksQueue tasksQueue, String link);
}