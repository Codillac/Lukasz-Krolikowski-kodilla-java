package com.kodilla.good.patterns.challenges.food2door.subcontractors;

import com.kodilla.good.patterns.challenges.food2door.products.Product;

public class ExtraFoodShopSubcontractor implements Subcontractor {

    public boolean process(final Product product, final int quantity) {
        System.out.println("<ExtraFoodSop> I am sending message directly to our depot worker." );
        System.out.println("Hey, Joe! Prepare " + product.getProductName() + ", in quantity: " + quantity );
        return true;
    }
}
