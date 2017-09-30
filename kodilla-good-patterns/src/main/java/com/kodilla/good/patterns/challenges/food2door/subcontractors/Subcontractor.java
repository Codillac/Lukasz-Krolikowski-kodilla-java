package com.kodilla.good.patterns.challenges.food2door.subcontractors;

import com.kodilla.good.patterns.challenges.food2door.products.Product;

public interface Subcontractor {
    boolean process(final Product product, final int quantity);
}
