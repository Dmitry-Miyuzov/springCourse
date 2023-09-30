package ru.dima.beans.shape.concrete;

import ru.dima.beans.shape._base.Coords;
import ru.dima.beans.shape._base.Shape;
import ru.dima.beans.shape.utils.Color;

public class Circle extends Shape {
    private int radius;

    public Circle(Coords coords, Color color, int radius) {
        super(coords, color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.printf("Нарисовать круг c координатами x = %f, y = %f. Цвет = %s. Радиус = %d.%n",
                coords.getX(), coords.getY(), color, radius);
    }
}
