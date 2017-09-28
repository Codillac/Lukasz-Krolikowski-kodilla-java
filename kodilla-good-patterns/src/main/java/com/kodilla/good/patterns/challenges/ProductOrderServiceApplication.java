package com.kodilla.good.patterns.challenges;

public class ProductOrderServiceApplication {

    public static void main(String[] args) {

        ProductOrderRequest productOrderRequest = new ProductOrderRequest(new User("maestro83", "John", "Snow"), new ElectronicProduct("Apple IPad", 4500.0), 4);
        ProductOrderRequest productOrderRequest2 = new ProductOrderRequest(new User("china99", "Arya", "Stark"), new ElectronicProduct("Apple IPhone", 3000.11), 12);

        ProductOrderRepository productOrderRepository = new StandardProductsOrderRepository();

        OrderProcessor orderProcessor = new OrderProcessor(new ProductOrderService(), productOrderRepository, new  EMailInformationService());

         ProductOrderDto productOrderDto = orderProcessor.process(productOrderRequest);
         System.out.println("Is user " + productOrderDto.getUser().getNickname() + " just ordered " + productOrderDto.getProduct().getProductName() + "? " + productOrderDto.isProductOrderedByTheUser());

         orderProcessor.process(productOrderRequest2);

         productOrderRepository.showOrders();
    }
}
