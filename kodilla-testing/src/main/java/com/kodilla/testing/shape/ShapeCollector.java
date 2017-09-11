package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    ArrayList<Shape> figures = new ArrayList<Shape>();

    public void addFigure(Shape shape){
        figures.add(shape);
    }

    public void removeFigure(Shape shape) {
        if(figures.contains(shape)){
            figures.remove(shape);
        }
    }

    public Shape getFigure(int n){
        Shape result = null;
        if(n >= 0 && n < figures.size()){
            result = figures.get(n);
        }
        return result;
    }

    public void showFigures(){
        // does nothing
    }
}
