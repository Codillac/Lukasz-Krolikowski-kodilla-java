package com.kodilla.testing.shape;

import org.junit.Assert;
import org.junit.Test;

public class ShapeCollectorTestSuite {
    @Test
    public void testAddFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shapeExample = new Square(5.25);

        //When
        shapeCollector.addFigure(shapeExample);
        int result = shapeCollector.figures.size();

        //Then
        Assert.assertEquals(1, result);
    }

    @Test
    public void testRemoveFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shapeExample = new Square(5.25);
        shapeCollector.addFigure(shapeExample);

        //When
        shapeCollector.removeFigure(shapeExample);

        //Then
        Assert.assertTrue(shapeCollector.getFigure(0) == null);
    }

    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shapeExample = new Square(5.25);
        shapeCollector.addFigure(shapeExample);

        //When
        Shape result = shapeCollector.getFigure(0);

        //Then
        Assert.assertEquals(shapeExample, result);
    }
}
