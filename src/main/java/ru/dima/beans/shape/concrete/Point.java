package ru.dima.beans.shape.concrete;

import org.springframework.stereotype.Component;
import ru.dima.beans.shape._base.Coords;
import ru.dima.beans.shape._base.Shape;

@Component
public class Point extends Shape {

    public Point(Coords coords, String color) {
        super(coords, color);
    }

    @Override
    public void draw() {
        System.out.printf("Поставить точку в координате x = %f, y = %f. Цвет = %s.%n",
                coords.getX(), coords.getY(), color);
    }
}
