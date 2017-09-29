package com.kodilla.good.patterns.challenges.challenge2.orders;

import com.kodilla.good.patterns.challenges.challenge2.products.Product;
import com.kodilla.good.patterns.challenges.challenge2.users.User;

public class ProductOrderRequest implements Order {

    private User user;
    private Product product;
    private int quantity;

    public ProductOrderRequest(final User user, final Product product, final int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
