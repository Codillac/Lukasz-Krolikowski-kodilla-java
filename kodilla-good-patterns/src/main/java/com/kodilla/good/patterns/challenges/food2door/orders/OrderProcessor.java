package com.kodilla.good.patterns.challenges.food2door.orders;

import com.kodilla.good.patterns.challenges.food2door.products.ProductRepository;
import com.kodilla.good.patterns.challenges.food2door.subcontractors.Subcontractor;

public class OrderProcessor {

    private final ProductRepository productRepository;

    public OrderProcessor(final ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public ProcessOrderDto processOrder(OrderRequest orderRequest) {

        Subcontractor subcontractor = productRepository.getProductDeliverer(orderRequest.getProduct());

        boolean ifOrdered = subcontractor.process(orderRequest.getProduct(), orderRequest.getQuantity());
            return new ProcessOrderDto(orderRequest, ifOrdered);
    }
}
