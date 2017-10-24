package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String DEFAULT_DEDCRIPTION = "Task Lists are very useful";
    private static final String TODO = "To Do List";
    private static final String INPROGRESS = "In Progress List";
    private static final String DONE = "Done List";

    @Test
    public void testFindByListName() {
        //Given
        TaskList toDoTaskList = new TaskList(TODO, DEFAULT_DEDCRIPTION);
        TaskList inProgressTaskList = new TaskList(INPROGRESS, DEFAULT_DEDCRIPTION);
        TaskList doneTaskList = new TaskList(DONE, DEFAULT_DEDCRIPTION);
        taskListDao.save(toDoTaskList);
        taskListDao.save(inProgressTaskList);
        taskListDao.save(doneTaskList);

        //When
        List<TaskList> readFindByFirstListName = taskListDao.findByListName(TODO);
        List<TaskList> readFindBySecondListName = taskListDao.findByListName(INPROGRESS);
        List<TaskList> readFindByThirdListName = taskListDao.findByListName(DONE);
        String resultForToDoList = readFindByFirstListName.get(0).getListName();
        String resultForInProgressList = readFindBySecondListName.get(0).getListName();
        String resultForDoneList = readFindByThirdListName.get(0).getListName();

        //Then
        Assert.assertEquals(1, readFindByFirstListName.size());
        Assert.assertEquals(1, readFindBySecondListName.size());
        Assert.assertEquals(1, readFindByThirdListName.size());
        Assert.assertEquals(TODO, resultForToDoList);
        Assert.assertEquals(INPROGRESS, resultForInProgressList);
        Assert.assertEquals(DONE, resultForDoneList);

        //CleanUp
        taskListDao.deleteAll();
    }
}
