package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    public boolean orderProduct(ProductOrderRequest productOrderRequest) {
        double totalPrice = productOrderRequest.getQuantity() * productOrderRequest.getProduct().getProductPrice();
        System.out.println("Ordering product: " + productOrderRequest.getProduct().getProductName() + ", for: " + productOrderRequest.getUser().getNickname() + ". Qty: " + productOrderRequest.getQuantity() + ", TOTAL PRICE: " + totalPrice);
        return true;
    }
}