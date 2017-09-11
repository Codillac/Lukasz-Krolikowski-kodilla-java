package com.kodilla.testing.shape;

public class Square implements Shape {
     double side;

    public Square(double side) {
        this.side = side;
    }

    public String getShapeName(){
        return "square";
    }

    public double getField(){
        return side*side;
    }
}
