package com.kodilla.patterns.strategy;

public class BalancedPredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[BalancedPredictor] Buy shared units of Fund XYZ";
    }
}
