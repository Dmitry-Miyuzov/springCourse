package ru.dima.beans.shape.concrete;

import ru.dima.beans.shape._base.Coords;
import ru.dima.beans.shape._base.Shape;
import ru.dima.beans.shape.utils.Color;

public class Point extends Shape {

    public Point(Coords coords, Color color) {
        super(coords, color);
    }

    @Override
    public void draw() {
        System.out.printf("Поставить точку в координате x = %f, y = %f. Цвет = %s.%n",
                coords.getX(), coords.getY(), color);
    }
}
