package com.kodilla.testing.weather.stub;

import java.util.HashMap;

public class TemperaturesStub implements Temperatures {
    @Override
    public HashMap<Integer, Double> getTemperatures(){
        HashMap<Integer, Double> stubResult = new HashMap<Integer, Double>();

        // dummy data
        stubResult.put(0, 12.5);
        stubResult.put(1, 10.0);
        stubResult.put(2, 13.5);
        stubResult.put(3, 14.0);
        stubResult.put(4, 14.5);

        return stubResult;
    }
}
