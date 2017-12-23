package com.codilla.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

public class StudentTasksQueueTestSuite {
    @Test
    public void testNotifyAboutTheTask() {
        //Given
        Mentor mentor1 = new Mentor("Commander Spock");
        Mentor mentor2 = new Mentor("Carl Sagan");
        StudentTasksQueue tasksQueue1 = new StudentTasksQueue("Edsgar Dijkstra", mentor1);
        StudentTasksQueue tasksQueue2 = new StudentTasksQueue("Bjarne Stroustroup", mentor1);
        StudentTasksQueue tasksQueue3 = new StudentTasksQueue("Michio Kaku", mentor2);
        StudentTasksQueue tasksQueue4 = new StudentTasksQueue("Neil DeGrasse Tyson", mentor2);
        StudentTasksQueue tasksQueue5 = new StudentTasksQueue("Luke Skywalker", mentor2);

        //When
        tasksQueue1.submitTask("www.starhub.org/123");
        tasksQueue1.submitTask("www.starhub.org/124");
        tasksQueue2.submitTask("www.starhub.org/543");
        tasksQueue2.submitTask("www.starhub.org/544");
        tasksQueue2.submitTask("www.starhub.org/545");
        tasksQueue3.submitTask("www.cosmoshub.com/111");
        tasksQueue4.submitTask("www.cosmoshub.com/0999");
        tasksQueue4.submitTask("www.cosmoshub.com/1000");
        tasksQueue4.submitTask("www.cosmoshub.com/1001");
        tasksQueue5.submitTask("www.cosmoshub.com/0256");
        tasksQueue5.submitTask("www.cosmoshub.com/0512");
        tasksQueue5.submitTask("www.cosmoshub.com/1024");

        //Then
        Assert.assertEquals(5, mentor1.getNumberOfTasksToCheck());
        Assert.assertEquals(7, mentor2.getNumberOfTasksToCheck());
    }
}
