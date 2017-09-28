package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class StandardProductsOrderRepository implements ProductOrderRepository {

    private LocalDate lastOrderDate = LocalDate.now();
    private Integer currentDayOrderNumber = 0;
    private final Map<String, Order> orders = new HashMap<>();

    public void createOrder(final Order order, final LocalDate localDate) {

        if(lastOrderDate.equals(localDate)) {
            currentDayOrderNumber++;
        } else if(lastOrderDate.isBefore(localDate)) {
            currentDayOrderNumber = 0;
            lastOrderDate = localDate;
        }

        String currentOrderId = localDate.toString().replace("-", "") + Integer.toString(currentDayOrderNumber);
        orders.put(currentOrderId, order);
    }

    public void showOrders() {

        System.out.println("Orders in repository: ");

        for (Map.Entry<String, Order> currentEntry : orders.entrySet()) {
            System.out.println("Order ID: " + currentEntry.getKey() + " Ordered product: " + currentEntry.getValue().getProduct().getProductName() + " Ordered by: " +currentEntry.getValue().getUser().getName() + " " + currentEntry.getValue().getUser().getSurname());
        }
    }
}