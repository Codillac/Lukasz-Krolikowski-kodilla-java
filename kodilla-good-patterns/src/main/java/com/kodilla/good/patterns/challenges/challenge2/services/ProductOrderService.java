package com.kodilla.good.patterns.challenges.challenge2.services;

import com.kodilla.good.patterns.challenges.challenge2.orders.ProductOrderRequest;

public class ProductOrderService {

    public boolean orderProduct(ProductOrderRequest productOrderRequest) {
        double totalPrice = productOrderRequest.getQuantity() * productOrderRequest.getProduct().getProductPrice();
        System.out.println("Ordering product: " + productOrderRequest.getProduct().getProductName() + ", for: " + productOrderRequest.getUser().getNickname() + ". Qty: " + productOrderRequest.getQuantity() + ", TOTAL PRICE: " + totalPrice);
        return true;
    }
}