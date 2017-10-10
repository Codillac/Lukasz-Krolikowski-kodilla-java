package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BoardConfig {
    @Bean("toDoList")
    TaskList initializeToDoList() {
        return new TaskList();
    }

    @Bean("inProgressList")
    TaskList initializeInProgressList() {
        return new TaskList();
    }

    @Bean("doneList")
    TaskList initializeDoneList() {
        return new TaskList();
    }

    @Bean
    Board injectToBoard() {
        return new Board(initializeToDoList(), initializeInProgressList(), initializeDoneList());
    }
}
