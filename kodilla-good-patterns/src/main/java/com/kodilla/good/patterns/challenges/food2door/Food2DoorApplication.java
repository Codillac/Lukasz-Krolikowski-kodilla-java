package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.orders.OrderProcessor;
import com.kodilla.good.patterns.challenges.food2door.orders.OrderRequest;
import com.kodilla.good.patterns.challenges.food2door.orders.ProcessOrderDto;
import com.kodilla.good.patterns.challenges.food2door.products.OrganicFoodProduct;
import com.kodilla.good.patterns.challenges.food2door.products.ProductRepository;

public class Food2DoorApplication {

    public static void main(String[] args) {

        ProductRepository productRepository = new ProductRepository();

        OrderRequest orderRequest1 = new OrderRequest(productRepository.getProductFromRepository(new OrganicFoodProduct("Curly Kale", 3.25, true)), 3);
        OrderRequest orderRequest2 = new OrderRequest(productRepository.getProductFromRepository(new OrganicFoodProduct("Corn Bread", 8.0, true)), 8);
        OrderRequest orderRequest3 = new OrderRequest(productRepository.getProductFromRepository(new OrganicFoodProduct("Organic Tomato", 4.18, true)), 12);

        OrderProcessor orderProcessor = new OrderProcessor(productRepository);

        ProcessOrderDto processOrderDto1 = orderProcessor.processOrder(orderRequest1);
        ProcessOrderDto processOrderDto2 = orderProcessor.processOrder(orderRequest2);
        ProcessOrderDto processOrderDto3 = orderProcessor.processOrder(orderRequest3);

        processOrderDto1.showOrderStatus();
        processOrderDto2.showOrderStatus();
        processOrderDto3.showOrderStatus();
    }
}
