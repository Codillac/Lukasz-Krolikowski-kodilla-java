package com.codilla.patterns2.observer.homework;

public interface Observable {
    void assignMentor(Observer mentor);
    void notifyMentor(String linkToTask);
}