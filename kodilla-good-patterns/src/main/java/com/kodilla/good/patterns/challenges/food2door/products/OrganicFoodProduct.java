package com.kodilla.good.patterns.challenges.food2door.products;

public class OrganicFoodProduct implements Product {

    private final String productName;
    private final double productPrice;
    private final boolean isGlutenFree;

    public OrganicFoodProduct(final String productName, final double productPrice, final boolean isGlutenFree) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.isGlutenFree = isGlutenFree;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productName.hashCode();
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isGlutenFree ? 1 : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganicFoodProduct that = (OrganicFoodProduct) o;

        if (Double.compare(that.productPrice, productPrice) != 0) return false;
        if (isGlutenFree != that.isGlutenFree) return false;
        return productName.equals(that.productName);
    }

    @Override
    public String toString() {
        return "OrganicFoodProduct{" +
                "productName='" + productName + '\'' +
                ",productPrice=" + productPrice +
                ",isGlutenFree=" + isGlutenFree +
                '}';
    }
}
