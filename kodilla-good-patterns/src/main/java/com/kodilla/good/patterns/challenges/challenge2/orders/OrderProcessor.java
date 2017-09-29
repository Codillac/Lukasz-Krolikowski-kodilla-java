package com.kodilla.good.patterns.challenges.challenge2.orders;

import com.kodilla.good.patterns.challenges.challenge2.services.InformationService;
import com.kodilla.good.patterns.challenges.challenge2.services.ProductOrderService;

import java.time.LocalDate;

public class OrderProcessor {

    private ProductOrderService productOrderService;
    private ProductOrderRepository productOrderRepository;
    private InformationService informationService;

    public OrderProcessor(final ProductOrderService productOrderService, final ProductOrderRepository productOrderRepository, final InformationService informationService) {
        this.productOrderService = productOrderService;
        this.productOrderRepository = productOrderRepository;
        this.informationService = informationService;
    }

    public ProductOrderDto process(ProductOrderRequest orderRequest) {
        boolean isOrdered = productOrderService.orderProduct(orderRequest);

        if (isOrdered){
            informationService.inform(orderRequest.getUser());
            productOrderRepository.createOrder(orderRequest, LocalDate.now());
            return new ProductOrderDto(orderRequest.getUser(), orderRequest.getProduct(), true);
        } else {
            return new ProductOrderDto(orderRequest.getUser(), orderRequest.getProduct(), false);
        }
    }
}
