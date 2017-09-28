package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public interface ProductOrderRepository {
    void createOrder(final Order order, final LocalDate localDate);
    void showOrders();
}
