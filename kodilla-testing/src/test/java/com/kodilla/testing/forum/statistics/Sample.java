package com.kodilla.testing.forum.statistics;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Sample {

    @Mock
    public Statistics statistic;

    @Spy
    public SpyExample spyExample = new SpyExample();

    @Captor
    public ArgumentCaptor<CaptorExample> captor;

    @InjectMocks
    public InjectMocksExcemple injectMocksExcemple;

    private StatisticsCalculation statisticsCalculation;

    @Before
    public void before() {
        statisticsCalculation = new StatisticsCalculation();
    }

    @Test
    public void sampleTest() {

        //given
//        when(statistic.commentsCount()).thenReturn(123);
//        when(statistic.postsCount()).thenReturn(23);
//        when(statistic.userNames()).thenReturn(new ArrayList<>());

        //when
        injectMocksExcemple.getMessageFromSpyExample();

        //then
        verify(spyExample, times(1)).getInfo(captor.capture());
        CaptorExample captorExample = captor.getValue();

        assertThat(captorExample.getVariable(), is("aaa"));

    }
    @Test
    public void sampleTest2() {

        //given
        when(statistic.commentsCount()).thenReturn(123);
        when(statistic.postsCount()).thenReturn(23);
        when(statistic.userNames()).thenReturn(new ArrayList<>());

        //when
        String variable = injectMocksExcemple.getMessageFromSpyExample2();

        //then
        verify(spyExample, times(1)).getInfo2();
        assertThat(variable, is("some other value"));

    }

    @Test
    public void sampleTest3() {

        //given
        when(statistic.commentsCount()).thenReturn(123);
        when(statistic.postsCount()).thenReturn(23);
        when(statistic.userNames()).thenReturn(new ArrayList<>());

        //when
        injectMocksExcemple.testMethod();

        //then
        verify(statistic, times(1)).commentsCount();

    }

}
