package ru.dima.beans.shape.concrete;

import org.springframework.stereotype.Component;
import ru.dima.beans.shape._base.Coords;
import ru.dima.beans.shape._base.Shape;

@Component
public class Circle extends Shape {
    private int radius;

    public Circle(Coords coords, String color, int radius) {
        super(coords, color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.printf("Нарисовать круг c координатами x = %f, y = %f. Цвет = %s. Радиус = %d.%n",
                coords.getX(), coords.getY(), color, radius);
    }
}
