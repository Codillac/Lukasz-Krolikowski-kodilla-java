package com.kodilla.patterns.factory;

import org.junit.Assert;
import org.junit.Test;

public class ShapeFactoryTestSuite {
    @Test
    public void testFactoryCircle() {
        //Given
        ShapeFactory shapeFactory = new ShapeFactory();

        //When
        Shape circle = shapeFactory.makeShape(shapeFactory.CIRCLE);

        //Then
        Assert.assertEquals(Math.PI * Math.pow(4.5, 2.0), circle.getField(), 0);
        Assert.assertEquals("The rounded circle", circle.getName());
    }

    @Test
    public void testFactorySquare() {
        //Given
        ShapeFactory shapeFactory = new ShapeFactory();

        //When
        Shape square = shapeFactory.makeShape(shapeFactory.SQUARE);

        //Then
        Assert.assertEquals(28.0, square.getCircumference(), 0);
        Assert.assertEquals("The angular square", square.getName());
    }

    @Test
    public void testFactoryRectangle() {
        //Given
        ShapeFactory shapeFactory = new ShapeFactory();

        //When
        Shape rectangle = shapeFactory.makeShape(shapeFactory.RECTANGLE);

        //Then
        Assert.assertEquals(37.5, rectangle.getField(), 0);
        Assert.assertEquals("The long rectangle", rectangle.getName());
    }
}
