package com.kodilla.spring.Reader;

import com.kodilla.spring.reader.IfDayIsOddCondition;
import com.kodilla.spring.reader.Reader;
import com.kodilla.spring.reader.ReaderConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class ReaderTestSuite {
    @Test
    public void testRead() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        Reader reader = context.getBean(Reader.class);

        //When
        boolean result = reader.read();

        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testConditional() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);

        //When
        boolean book2Exists = context.containsBean("book2");

        //Then
        System.out.println("The book2 was found in the container: " + book2Exists);

        if(LocalDate.now().getDayOfMonth() % 2 != 0) {
            Assert.assertTrue(book2Exists);
        } else {
            Assert.assertFalse(book2Exists);
        }
    }
}
