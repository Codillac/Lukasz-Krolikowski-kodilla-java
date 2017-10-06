package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        String taskFromToDoList = board.getToDoList().getTasks().stream()
                .findAny()
                .toString();
        String taskFromInProgressList = board.getInProgressList().getTasks().stream()
                .findAny()
                .toString();
        String taskFromDoneList = board.getDoneList().getTasks().stream()
                .findAny()
                .toString();

        //Then
        Assert.assertEquals("Optional[Learn Project Patterns]", taskFromToDoList);
        Assert.assertEquals("Optional[Learning Spring]", taskFromInProgressList);
        Assert.assertEquals("Optional[Learned Stream]", taskFromDoneList);
    }
}
