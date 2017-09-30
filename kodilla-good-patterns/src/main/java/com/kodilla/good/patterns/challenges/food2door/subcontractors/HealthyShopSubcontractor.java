package com.kodilla.good.patterns.challenges.food2door.subcontractors;

import com.kodilla.good.patterns.challenges.food2door.products.Product;

import java.util.ArrayDeque;
import java.util.Queue;

public class HealthyShopSubcontractor implements Subcontractor {

    private final static Queue<String> nextToHandleQueue = new ArrayDeque<>();

    public boolean process(final Product product, final int quantity) {

        System.out.println("<Healthy Shop> I am adding order to QUEUE of ORDERS.");
        return nextToHandleQueue.offer(product.getProductName() + ", qty: " + quantity);
    }
}
