package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    ArrayList<Shape> figures = new ArrayList<Shape>();

    public void addFigure(Shape shape){
        figures.add(shape);
    }

    public void removeFigure(Shape shape) {
        figures.remove(shape);
    }

    public Shape getFigure(int n){
        return figures.get(n);
    }

    public void showFigures(){
        for(Shape currentShape : figures){
            System.out.println("Shape: " + currentShape.getShapeName() + "Field: " + currentShape.getField());
        }
    }
}
