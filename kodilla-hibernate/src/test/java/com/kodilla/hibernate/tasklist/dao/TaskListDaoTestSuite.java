package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDao;
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

    @Autowired
    private TaskDao taskDao;

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

    @Test
    public void testNamedQueries() {
        //Given
        Task task1 = new Task("Test: Study Hibernate", 3);
        Task task2 = new Task("Test: Practice Named Queries", 6);
        Task task3 = new Task("Test: Study native queries", 7);
        Task task4 = new Task("Test: Make some tests", 13);

        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(5), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        TaskFinancialDetails tfd3 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd4 = new TaskFinancialDetails(new BigDecimal(15), false);

        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        task3.setTaskFinancialDetails(tfd3);
        task4.setTaskFinancialDetails(tfd4);

        TaskList taskList = new TaskList(TODO, "ToDo tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        taskList.getTasks().add(task3);
        taskList.getTasks().add(task4);

        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        task3.setTaskList(taskList);
        task4.setTaskList(taskList);

        taskListDao.save(taskList);
        int id = taskList.getId();

        //When
        List<Task> longTasks = taskDao.retrieveLongTasks();
        List<Task> shortTasks = taskDao.retrieveShortTasks();
        List<Task> enoughTimeTasks = taskDao.retrieveTasksWithEnoughTime();
        List<Task> durationLongerThanTasks = taskDao.retrieveTasksWithDurationLongerThan(6);

        //Then
        try {
            Assert.assertEquals(1, longTasks.size());
            Assert.assertEquals(3, shortTasks.size());
            Assert.assertEquals(3, enoughTimeTasks.size());
            Assert.assertEquals(2, durationLongerThanTasks.size());
        } finally {
            //CleanUp
            taskListDao.delete(id);
        }
    }
}
