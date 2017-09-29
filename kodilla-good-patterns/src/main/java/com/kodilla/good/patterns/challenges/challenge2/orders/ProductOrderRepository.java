package com.kodilla.good.patterns.challenges.challenge2.orders;

import com.kodilla.good.patterns.challenges.challenge2.orders.Order;

import java.time.LocalDate;

public interface ProductOrderRepository {
    void createOrder(final Order order, final LocalDate localDate);
    void showOrders();
}
