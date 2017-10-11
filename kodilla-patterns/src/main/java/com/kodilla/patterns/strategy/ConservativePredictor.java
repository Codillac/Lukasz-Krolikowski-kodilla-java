package com.kodilla.patterns.strategy;

public class ConservativePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[ConservativePredictor] Buy debentures of XYZ";
    }
}
