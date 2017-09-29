package com.kodilla.good.patterns.challenges.challenge2.orders;

import com.kodilla.good.patterns.challenges.challenge2.products.Product;
import com.kodilla.good.patterns.challenges.challenge2.users.User;

public interface Order {
    User getUser();
    Product getProduct();
    int getQuantity();
}
