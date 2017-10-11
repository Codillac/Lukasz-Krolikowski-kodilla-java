package com.kodilla.patterns.strategy;

public class AggressivePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[AggressivePredictor] Buy stock of XYZ";
    }
}
