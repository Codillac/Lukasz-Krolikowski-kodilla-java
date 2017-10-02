package com.kodilla.good.patterns.challenges.food2door.orders;

public final class ProcessOrderDto {

    private final OrderRequest orderRequest;
    private final boolean ifOrdered;

    public ProcessOrderDto(final OrderRequest orderRequest, final boolean ifOrdered) {
        this.orderRequest = orderRequest;
        this.ifOrdered = ifOrdered;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }

    public boolean isIfOrdered() {
        return ifOrdered;
    }

    public void showOrderStatus() {
        System.out.println("Product: " + orderRequest.getProduct().getProductName() + " is ordered: " + ifOrdered);
    }
}
