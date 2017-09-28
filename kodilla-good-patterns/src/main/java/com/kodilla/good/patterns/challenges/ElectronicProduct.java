package com.kodilla.good.patterns.challenges;

public class ElectronicProduct implements Product {

    private String productName;
    private double productPrice;

    public ElectronicProduct(final String productName, final double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }
}
