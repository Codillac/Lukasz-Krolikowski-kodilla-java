package com.kodilla.spring.intro.shape;

import com.kodilla.spring.intro.com.kodilla.spring.intro.shape.Circle;
import com.kodilla.spring.intro.com.kodilla.spring.intro.shape.Drawer;
import com.kodilla.spring.intro.com.kodilla.spring.intro.shape.Triangle;
import org.junit.Test;

public class testDoDrawing {

    @Test
    public void testDoDrawingWithCircle() {
        //Given
        Circle circle = new Circle();

        //When
        Drawer drawer = new Drawer(circle);
        drawer.doDrawing();

        //Ten
        //do nothing
    }

    @Test
    public void testDoDrawingWithTriangle() {
        //Given
        Triangle triangle = new Triangle();

        //When
        Drawer drawer = new Drawer(triangle);

        //Then
        //do nothing
    }
}
