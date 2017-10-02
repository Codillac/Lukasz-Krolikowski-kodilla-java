package com.kodilla.good.patterns.challenges.challenge2.orders;

import com.kodilla.good.patterns.challenges.challenge2.products.Product;
import com.kodilla.good.patterns.challenges.challenge2.users.User;

public class ProductOrderDto {

    private User user;
    private Product product;
    private boolean isProductOrderedByTheUser;

    public ProductOrderDto(final User user, final Product product, final boolean isProductOrderedByTheUser) {
        this.user = user;
        this.product = product;
        this.isProductOrderedByTheUser = isProductOrderedByTheUser;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isProductOrderedByTheUser() {
        return isProductOrderedByTheUser;
    }
}
