package com.kodilla.testing.forum.statistics;

public class InjectMocksExcemple {

    private Statistics statistics;

    private SpyExample spyExample;

    private CaptorExample captorExample;

    public InjectMocksExcemple(Statistics statistics, SpyExample spyExample) {
        this.statistics = statistics;
        this.spyExample = spyExample;
    }

    public void testMethod(){

        statistics.commentsCount();

    }

    public String getMessageFromSpyExample2(){
        return  spyExample.getInfo2();
    }

    public String getMessageFromSpyExample(){
        captorExample = new CaptorExample();
        captorExample.setVariable("aaa");

        return spyExample.getInfo(captorExample);
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public SpyExample getSpyExample() {
        return spyExample;
    }

    public void setSpyExample(SpyExample spyExample) {
        this.spyExample = spyExample;
    }
}
