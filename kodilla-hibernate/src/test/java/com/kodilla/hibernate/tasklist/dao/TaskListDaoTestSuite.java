package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    private static final String DEFAULT_DESCRIPTION = "Task Lists are very useful";
    private static final String TODO = "To Do List";
    private static final String INPROGRESS = "In Progress List";
    private static final String DONE = "Done List";

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //Given
        TaskList toDoTaskList = new TaskList(TODO, DEFAULT_DESCRIPTION);
        TaskList inProgressTaskList = new TaskList(INPROGRESS, DEFAULT_DESCRIPTION);
        TaskList doneTaskList = new TaskList(DONE, DEFAULT_DESCRIPTION);
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

    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(TODO, "ToDoTasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //Cleanup
        taskListDao.delete(id);
    }
}
