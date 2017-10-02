package com.kodilla.good.patterns.challenges.food2door.products;

import com.kodilla.good.patterns.challenges.food2door.subcontractors.ExtraFoodShopSubcontractor;
import com.kodilla.good.patterns.challenges.food2door.subcontractors.GlutenFreeShopSubcontractor;
import com.kodilla.good.patterns.challenges.food2door.subcontractors.HealthyShopSubcontractor;
import com.kodilla.good.patterns.challenges.food2door.subcontractors.Subcontractor;

import java.util.*;
import java.util.stream.Collectors;

public class ProductRepository {

    private final List<Product> products = new ArrayList<>();
    private final Map<Product, Subcontractor> productSubcontractorMap = new HashMap<>();

    public ProductRepository() {

        Subcontractor glutenFreeShopSubcontractor = new GlutenFreeShopSubcontractor();
        Subcontractor extraFoodShopSubcontractor = new ExtraFoodShopSubcontractor();
        Subcontractor healthyShopSubcontractor = new HealthyShopSubcontractor();

        products.add(new OrganicFoodProduct("Soy Beans", 5.99, true));
        products.add(new OrganicFoodProduct("Millet Groats", 6.15, true));
        products.add(new OrganicFoodProduct("Wholegrain Bread", 2.5, false));
        products.add(new OrganicFoodProduct("Curly Kale", 3.25, true));
        products.add(new OrganicFoodProduct("Organic Tomato", 4.18, true));
        products.add(new OrganicFoodProduct("Oatmeal", 1.99, false));
        products.add(new OrganicFoodProduct("Amaranth Wheat", 6.99, true));
        products.add(new OrganicFoodProduct("Pure Barley", 5.0, false));
        products.add(new OrganicFoodProduct("Corn Bread", 8.0, true));

        productSubcontractorMap.put(products.get(0), glutenFreeShopSubcontractor);
        productSubcontractorMap.put(products.get(1), glutenFreeShopSubcontractor);
        productSubcontractorMap.put(products.get(2), healthyShopSubcontractor);
        productSubcontractorMap.put(products.get(3), extraFoodShopSubcontractor);
        productSubcontractorMap.put(products.get(4), healthyShopSubcontractor);
        productSubcontractorMap.put(products.get(5), extraFoodShopSubcontractor);
        productSubcontractorMap.put(products.get(6), glutenFreeShopSubcontractor);
        productSubcontractorMap.put(products.get(7), healthyShopSubcontractor);
        productSubcontractorMap.put(products.get(8), glutenFreeShopSubcontractor);
    }

    public Subcontractor getProductDeliverer(Product product) {

        return productSubcontractorMap.get(product);
    }

    public Product getProductFromRepository(Product product) {

        return products.get(products.indexOf(product));
    }
}
