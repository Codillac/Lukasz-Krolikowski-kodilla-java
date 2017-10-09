package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().addTask("Learn Project Patterns");
        board.getInProgressList().addTask("Learning Spring");
        board.getDoneList().addTask("Learned Stream");

        Optional<String> taskFromToDoList = board.getToDoList().getTasks().stream()
                .findAny();
        Optional <String> taskFromInProgressList = board.getInProgressList().getTasks().stream()
                .findAny();
        Optional<String> taskFromDoneList = board.getDoneList().getTasks().stream()
                .findAny();

        //Then
        Assert.assertTrue(taskFromToDoList.isPresent());
        Assert.assertTrue(taskFromInProgressList.isPresent());
        Assert.assertTrue(taskFromDoneList.isPresent());
    }
}
